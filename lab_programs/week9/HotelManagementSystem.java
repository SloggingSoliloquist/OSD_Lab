import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HotelManagementSystem extends Application {

    // Data models
    public static class Room {
        private final IntegerProperty number;
        private final StringProperty type;
        private final DoubleProperty price;
        private final BooleanProperty available;

        public Room(int number, String type, double price, boolean available) {
            this.number = new SimpleIntegerProperty(number);
            this.type = new SimpleStringProperty(type);
            this.price = new SimpleDoubleProperty(price);
            this.available = new SimpleBooleanProperty(available);
        }

        public int getNumber() { return number.get(); }
        public String getType() { return type.get(); }
        public double getPrice() { return price.get(); }
        public boolean isAvailable() { return available.get(); }

        public void setAvailable(boolean val) { available.set(val); }

        public IntegerProperty numberProperty() { return number; }
        public StringProperty typeProperty() { return type; }
        public DoubleProperty priceProperty() { return price; }
        public BooleanProperty availableProperty() { return available; }
    }

    public static class Customer {
        private final StringProperty name;
        private final StringProperty contact;
        private final IntegerProperty roomNumber;

        public Customer(String name, String contact, int roomNumber) {
            this.name = new SimpleStringProperty(name);
            this.contact = new SimpleStringProperty(contact);
            this.roomNumber = new SimpleIntegerProperty(roomNumber);
        }

        public String getName() { return name.get(); }
        public String getContact() { return contact.get(); }
        public int getRoomNumber() { return roomNumber.get(); }

        public StringProperty nameProperty() { return name; }
        public StringProperty contactProperty() { return contact; }
        public IntegerProperty roomNumberProperty() { return roomNumber; }
    }

    private final ObservableList<Room> rooms = FXCollections.observableArrayList();
    private final ObservableList<Customer> customers = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();

        Tab roomTab = new Tab("Rooms", createRoomPane());
        Tab customerTab = new Tab("Customers", createCustomerPane());

        roomTab.setClosable(false);
        customerTab.setClosable(false);

        tabPane.getTabs().addAll(roomTab, customerTab);

        Scene scene = new Scene(tabPane, 900, 600);
        stage.setTitle("Hotel Management System");
        stage.setScene(scene);
        stage.show();
    }

    private Pane createRoomPane() {
        TableView<Room> table = new TableView<>(rooms);

        TableColumn<Room, Number> numCol = new TableColumn<>("Room No");
        numCol.setCellValueFactory(data -> data.getValue().numberProperty());

        TableColumn<Room, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(data -> data.getValue().typeProperty());

        TableColumn<Room, Number> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(data -> data.getValue().priceProperty());

        TableColumn<Room, Boolean> availCol = new TableColumn<>("Available");
        availCol.setCellValueFactory(data -> data.getValue().availableProperty());

        table.getColumns().addAll(numCol, typeCol, priceCol, availCol);

        TextField numField = new TextField();
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Single", "Double", "Deluxe");
        TextField priceField = new TextField();

        Button addBtn = new Button("Add Room");
        Button showAvailBtn = new Button("Show Available");

        addBtn.setOnAction(e -> {
            try {
                int num = Integer.parseInt(numField.getText());
                double price = Double.parseDouble(priceField.getText());
                rooms.add(new Room(num, typeBox.getValue(), price, true));
                clearFields(numField, priceField);
            } catch (Exception ex) {
                showAlert("Error adding room");
            }
        });

        showAvailBtn.setOnAction(e -> {
            table.setItems(rooms.filtered(Room::isAvailable));
        });

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Room No:"), 0, 0);
        form.add(numField, 1, 0);
        form.add(new Label("Type:"), 0, 1);
        form.add(typeBox, 1, 1);
        form.add(new Label("Price:"), 0, 2);
        form.add(priceField, 1, 2);
        form.add(addBtn, 0, 3);
        form.add(showAvailBtn, 1, 3);

        VBox layout = new VBox(10, form, table);
        layout.setPadding(new Insets(10));
        return layout;
    }

    private Pane createCustomerPane() {
        TableView<Customer> table = new TableView<>(customers);

        TableColumn<Customer, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());

        TableColumn<Customer, String> contactCol = new TableColumn<>("Contact");
        contactCol.setCellValueFactory(data -> data.getValue().contactProperty());

        TableColumn<Customer, Number> roomCol = new TableColumn<>("Room No");
        roomCol.setCellValueFactory(data -> data.getValue().roomNumberProperty());

        table.getColumns().addAll(nameCol, contactCol, roomCol);

        TextField nameField = new TextField();
        TextField contactField = new TextField();
        TextField roomField = new TextField();

        Button bookBtn = new Button("Book");
        Button checkoutBtn = new Button("Checkout");

        bookBtn.setOnAction(e -> {
            try {
                int roomNo = Integer.parseInt(roomField.getText());
                Room room = rooms.stream().filter(r -> r.getNumber() == roomNo).findFirst().orElse(null);
                if (room == null || !room.isAvailable()) {
                    showAlert("Room not available");
                    return;
                }
                room.setAvailable(false);
                customers.add(new Customer(nameField.getText(), contactField.getText(), roomNo));
                clearFields(nameField, contactField, roomField);
            } catch (Exception ex) {
                showAlert("Booking failed");
            }
        });

        checkoutBtn.setOnAction(e -> {
            Customer selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                rooms.stream().filter(r -> r.getNumber() == selected.getRoomNumber()).forEach(r -> r.setAvailable(true));
                customers.remove(selected);
            }
        });

        GridPane form = new GridPane();
        form.setPadding(new Insets(10));
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Name:"), 0, 0);
        form.add(nameField, 1, 0);
        form.add(new Label("Contact:"), 0, 1);
        form.add(contactField, 1, 1);
        form.add(new Label("Room No:"), 0, 2);
        form.add(roomField, 1, 2);
        form.add(bookBtn, 0, 3);
        form.add(checkoutBtn, 1, 3);

        VBox layout = new VBox(10, form, table);
        layout.setPadding(new Insets(10));
        return layout;
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }

    private void clearFields(TextField... fields) {
        for (TextField f : fields) f.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
