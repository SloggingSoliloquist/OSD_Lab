import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.*;

public class PharmacyApp extends Application {
    // 1. DATA STRUCTURES
    // HashMap is our "Source of Truth" for fast ID lookups
    private HashMap<String, Medicine> inventoryMap = new HashMap<>();
    private ObservableList<Medicine> tableData = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        // --- UI: INPUT FORM (GridPane) ---
        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(10);

        TextField idIn = new TextField(); idIn.setPromptText("ID");
        TextField nameIn = new TextField(); nameIn.setPromptText("Name");
        TextField priceIn = new TextField(); priceIn.setPromptText("Price");
        TextField qtyIn = new TextField(); qtyIn.setPromptText("Qty");

        form.add(new Label("ID:"), 0, 0); form.add(idIn, 1, 0);
        form.add(new Label("Name:"), 0, 1); form.add(nameIn, 1, 1);
        form.add(new Label("Price:"), 2, 0); form.add(priceIn, 3, 0);
        form.add(new Label("Qty:"), 2, 1); form.add(qtyIn, 3, 1);

        // --- BUTTON LOGIC: ADD/UPDATE (HashMap Logic) ---
        Button addBtn = new Button("Add/Update Stock");
        addBtn.setOnAction(e -> {
            try {
                String id = idIn.getText();
                int qty = Integer.parseInt(qtyIn.getText());

                if (inventoryMap.containsKey(id)) {
                    // MAP LOGIC: Update existing object
                    Medicine existing = inventoryMap.get(id);
                    existing.setQuantity(existing.getQuantity() + qty);
                } else {
                    // MAP LOGIC: Create new entry
                    Medicine m = new Medicine(id, nameIn.getText(), 
                                 Double.parseDouble(priceIn.getText()), qty);
                    inventoryMap.put(id, m);
                }
                syncTable(); // Refresh the UI
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
            }
        });

        // --- BUTTON LOGIC: SORT (ArrayList Logic) ---
        Button sortBtn = new Button("Sort by Price");
        sortBtn.setOnAction(e -> {
            // Convert Map values to List to use Sorting
            ArrayList<Medicine> sortedList = new ArrayList<>(inventoryMap.values());
            sortedList.sort((m1, m2) -> Double.compare(m1.getPrice(), m2.getPrice()));
            
            tableData.setAll(sortedList); // Update UI with sorted list
        }); 

        // --- TABLE VIEW ---
        TableView<Medicine> table = new TableView<>(tableData);
        TableColumn<Medicine, String> col1 = new TableColumn<>("ID");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Medicine, String> col2 = new TableColumn<>("Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Medicine, Double> col3 = new TableColumn<>("Price");
        col3.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Medicine, Integer> col4 = new TableColumn<>("Qty");
        col4.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        
        table.getColumns().addAll(col1, col2, col3, col4);

        root.getChildren().addAll(form, new HBox(10, addBtn, sortBtn), table);
        stage.setScene(new Scene(root, 600, 500));
        stage.setTitle("Pharmacy Inventory - HashMap & ArrayList Demo");
        stage.show();
    }

    // REFRESH METHOD: The "Bridge" between Map and Table
    private void syncTable() {
        tableData.clear();
        tableData.addAll(inventoryMap.values());
    }

    public static void main(String[] args) { launch(args); }
}