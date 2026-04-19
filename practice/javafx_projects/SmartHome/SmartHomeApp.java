import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
//define what objects you want the UI to actually use

public class SmartHomeApp extends Application{
    @Override
    public void start(Stage stage){
  Label title = new Label("Hotel Automation System");
  TextField nameInput=new TextField();
  nameInput.setPromptText("Device name");

  ComboBox<String> roomDropdown =new ComboBox<>();
  roomDropdown.getItems().addAll("Living Room", "Bedroom", "Kitchen");
  roomDropdown.setPromptText("select room");

  Button addBtn = new Button("Add device");
  TableView<Device> table = new TableView<>();
  TableColumn<Device, String> nameCol= new TableColumn<>("Device Name");
  nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));//should match the getter in Device

  TableColumn<Device, String> roomCol= new TableColumn<>("Room type");
  roomCol.setCellValueFactory(new PropertyValueFactory<>("room"));

  table.getColumns().addAll(nameCol, roomCol);
ObservableList<Device> data = FXCollections.observableArrayList();
        table.setItems(data);
    addBtn.setOnAction(e->{
        String name=nameInput.getText();
        String room=roomDropdown.getValue();

        if(name!=null && room!=null){
            data.add(new Device(name, room));
            nameInput.clear();
        }
    });
    VBox inputSection= new VBox(10, title, nameInput, roomDropdown, addBtn);
    HBox mainLayout = new HBox(20, inputSection, table);

    Scene scene = new Scene(mainLayout, 600, 400);
    stage.setScene(scene);
    stage.setTitle("Pls Work");
    stage.show();
}
public static void main(String[] args){
    launch(args);
}
}
