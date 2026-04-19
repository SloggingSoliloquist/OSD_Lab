import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
public class GymManagement extends Application{
    //make observable list for table items
    ObservableList<Member> members = FXCollections.observableArrayList();
    public void start(Stage stage){
        //tab pane
        TabPane tabs = new TabPane();
        Tab registration= new Tab("Registration");
        //grid pane 
        GridPane reg_grid = new GridPane();
        reg_grid.setHgap(15); 
        reg_grid.setVgap(20);
        reg_grid.setPadding(new Insets(25));
        reg_grid.add(new Label("Enter ID: "),0,0);
        TextField id_input = new TextField();
        id_input.setPromptText("Enter ID");
        reg_grid.add(id_input, 0,1);
        reg_grid.add(new Label("Enter name: "), 1,0);
        TextField name_input = new TextField();
        name_input.setPromptText("Enter name");
        reg_grid.add(name_input, 1,1);
        Label gender_label = new Label("Gender: ");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup gender_group = new ToggleGroup();
        male.setToggleGroup(gender_group);
        female.setToggleGroup(gender_group);
        FlowPane gender_pane = new FlowPane(gender_label, male, female);
        ComboBox<String> plan_box = new ComboBox<>();
        plan_box.getItems().addAll("Basic","Premium");
        reg_grid.add(plan_box, 2,0);
        reg_grid.add(gender_pane, 2,1);
        TextField date_input  = new TextField();
        reg_grid.add(date_input, 3,0);
        Button addBtn = new Button("Add registration");
        addBtn.setOnAction(e->{
            try{
                if(id_input.getText().isEmpty()||name_input.getText().isEmpty()){
                    throw new Exception("Empty fields");
                }
                RadioButton selectedBtn = (RadioButton) gender_group.getSelectedToggle();
                String gender = selectedBtn.getText();
                Member member= new Member(id_input.getText(), name_input.getText(),plan_box.getValue(), gender, date_input.getText());
                members.add(member);
                id_input.clear();
                name_input.clear();
            gender_group.selectToggle(null);            
        }
            catch (Exception ex){
                new Alert(Alert.AlertType.WARNING,ex.getMessage()).show();
            }
        }
        );
        reg_grid.add(addBtn, 3, 1);
        registration.setContent(reg_grid);
        tabs.getTabs().add(registration);
        Tab display_tab = new Tab("Display Details");
        TableView<Member> table = new TableView<>();
        TableColumn<Member, String> id_col = new TableColumn<>();
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Member, String> name_col = new TableColumn<>();
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Member, String> plan_col = new TableColumn<>();
        plan_col.setCellValueFactory(new PropertyValueFactory<>("plan"));
        TableColumn<Member, String> gender_col = new TableColumn<>();
        gender_col.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Member, String> date_col = new TableColumn<>();
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.getColumns().addAll(id_col, name_col, plan_col, gender_col, date_col);

        TextField search_bar = new TextField();
        search_bar.setPromptText("Enter to search by name");
        FilteredList<Member> filter = new FilteredList<>(members, p->true);
        search_bar.textProperty().addListener((members, OldValue, NewValue)->
        {
            filter.setPredicate(member->{
                if (NewValue == null || NewValue.isEmpty()) return true;
                String lowerCaseFilter = NewValue.toLowerCase();
                if (member.getId().toLowerCase().contains(lowerCaseFilter)) return true;                
                return false; // No match
            }
            );
        }
    );
        table.setItems(filter);
        HBox hb= new HBox(search_bar, table);
        display_tab.setContent(hb);
        tabs.getTabs().add(display_tab); 
        Scene scene = new Scene(tabs,800,800);
        stage.setScene(scene);
        stage.show();     
    }
    public static void main(String[] args){
        launch(args);
    }
}