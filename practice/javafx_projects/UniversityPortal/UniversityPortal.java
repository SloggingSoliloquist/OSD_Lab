import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class UniversityPortal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- 1. ROOT LAYOUT (TabPane) ---
        // TabPane allows multiple "pages" in one window.
        TabPane rootTabPane = new TabPane();

        // --- 2. TAB 1: ADMISSION FORM (Uses GridPane) ---
        Tab admissionTab = new Tab("Student Admission");
        GridPane formGrid = new GridPane();
        formGrid.setPadding(new Insets(20));
        formGrid.setHgap(10); // Horizontal space between cells
        formGrid.setVgap(15); // Vertical space between cells

        // Components for GridPane
        formGrid.add(new Label("Full Name:"), 0, 0); // (Control, Column, Row)
        formGrid.add(new TextField(), 1, 0);

        formGrid.add(new Label("Date of Birth:"), 0, 1);
        formGrid.add(new DatePicker(), 1, 1); // Specialized Date Component

        formGrid.add(new Label("Gender:"), 0, 2);
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup(); // Grouping ensures only one is selected
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, male, female);
        formGrid.add(genderBox, 1, 2);

        formGrid.add(new Label("Department:"), 0, 3);
        ComboBox<String> deptCombo = new ComboBox<>();
        deptCombo.getItems().addAll("Computer Science", "Electronics", "Mechanical");
        formGrid.add(deptCombo, 1, 3);

        formGrid.add(new Label("Interests:"), 0, 4);
        // FlowPane: Items wrap to next line automatically
        FlowPane interestsFlow = new FlowPane(10, 10); 
        interestsFlow.getChildren().addAll(new CheckBox("AI"), new CheckBox("Robotics"), new CheckBox("Music"));
        formGrid.add(interestsFlow, 1, 4);

        Button submitBtn = new Button("Register Student");
        submitBtn.setMaxWidth(Double.MAX_VALUE); // Make button stretch
        formGrid.add(submitBtn, 1, 5);

        admissionTab.setContent(formGrid);

        // --- 3. TAB 2: COURSE VIEW (Uses BorderPane) ---
        Tab courseTab = new Tab("Course Directory");
        BorderPane courseLayout = new BorderPane();

        // Top: A simple header
        Label header = new Label("Available Courses 2026");
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        courseLayout.setTop(header);
        BorderPane.setMargin(header, new Insets(10));
        BorderPane.setAlignment(header, Pos.CENTER);

        // Center: A TableView (The structured data)
        TableView<String> courseTable = new TableView<>();
        TableColumn<String, String> nameCol = new TableColumn<>("Course Name");
        courseTable.getColumns().add(nameCol);
        courseLayout.setCenter(courseTable);

        // Left: A Sidebar using VBox
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(10));
        sidebar.setStyle("-fx-background-color: #f4f4f4;");
        sidebar.getChildren().addAll(new Label("Filters"), new Separator(), new Button("Active"), new Button("Archived"));
        courseLayout.setLeft(sidebar);

        courseTab.setContent(courseLayout);

        // --- 4. ASSEMBLY ---
        rootTabPane.getTabs().addAll(admissionTab, courseTab);
        rootTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Prevent closing tabs

        Scene scene = new Scene(rootTabPane, 800, 600);
        primaryStage.setTitle("Global University Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}