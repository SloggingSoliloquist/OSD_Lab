import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HospitalApp extends Application {
    
    // Data Storage
    ObservableList<Appointment> masterData = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        // --- 1. SEARCH SECTION (Functionality 3 & 4) ---
        TextField searchInput = new TextField();
        searchInput.setPromptText("Search by Patient ID or Doctor Name...");
        
        // --- 2. INPUT SECTION (Functionality 1) ---
        TextField idInput = new TextField(); idInput.setPromptText("Patient ID");
        TextField nameInput = new TextField(); nameInput.setPromptText("Patient Name");
        TextField drInput = new TextField(); drInput.setPromptText("Doctor Name");
        TextField dateInput = new TextField(); dateInput.setPromptText("Date/Time");
        Button addBtn = new Button("Register Appointment");

        // --- 3. TABLE SECTION (Functionality 2) ---
        TableView<Appointment> table = new TableView<>();
        
        TableColumn<Appointment, String> idCol = new TableColumn<>("Patient ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        
        TableColumn<Appointment, String> nameCol = new TableColumn<>("Patient Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        
        TableColumn<Appointment, String> drCol = new TableColumn<>("Doctor");
        drCol.setCellValueFactory(new PropertyValueFactory<>("doctorName"));

        table.getColumns().addAll(idCol, nameCol, drCol);

        // --- 4. FILTERING LOGIC (The "Search" magic) ---
        FilteredList<Appointment> filteredData = new FilteredList<>(masterData, p -> true);
        
        searchInput.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(appointment -> {
                if (newValue == null || newValue.isEmpty()) return true;
                
                String lowerCaseFilter = newValue.toLowerCase();
                if (appointment.getPatientId().toLowerCase().contains(lowerCaseFilter)) return true;
                if (appointment.getDoctorName().toLowerCase().contains(lowerCaseFilter)) return true;
                
                return false; // No match
            });
        });
        table.setItems(filteredData);

        // --- 5. REGISTER & CANCEL LOGIC (Functionality 1 & 5) ---
        addBtn.setOnAction(e -> {
            try {
                if(idInput.getText().isEmpty() || nameInput.getText().isEmpty()) 
                    throw new Exception("ID and Name are mandatory!");
                
                masterData.add(new Appointment(
                    idInput.getText(), nameInput.getText(), 
                    drInput.getText(), dateInput.getText()
                ));
                idInput.clear(); nameInput.clear();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        });

        Button cancelBtn = new Button("Cancel Selected Appointment");
        cancelBtn.setOnAction(e -> {
            Appointment selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                masterData.remove(selected);
            } else {
                new Alert(Alert.AlertType.WARNING, "Please select an appointment to cancel!").show();
            }
        });

        // --- 6. LAYOUT ASSEMBLY ---
        VBox leftForm = new VBox(10, new Label("Registration"), idInput, nameInput, drInput, dateInput, addBtn);
        VBox rightTable = new VBox(10, new Label("Search Records"), searchInput, table, cancelBtn);
        
        HBox root = new HBox(20, leftForm, rightTable);
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 900, 500);
        stage.setScene(scene);
        stage.setTitle("Hospital Management System v1.0");
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}