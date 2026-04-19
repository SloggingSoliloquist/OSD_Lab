import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HospitalManagement extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Controls
        Label lblHeader = new Label("Hospital Appointment System");
        TextField txtId = new TextField();
        txtId.setPromptText("Patient ID");
        Button btnAdd = new Button("Register");

        // 2. Layout (VBox for simplicity)
        VBox root = new VBox(10); // 10px spacing
        root.getChildren().addAll(lblHeader, txtId, btnAdd);

        // 3. Event Handling
        btnAdd.setOnAction(e -> {
            if(txtId.getText().isEmpty()) {
                System.out.println("Error: ID is empty!"); // Basic validation
            }
        });

        // 4. Scene & Stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Endsem Prep");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}