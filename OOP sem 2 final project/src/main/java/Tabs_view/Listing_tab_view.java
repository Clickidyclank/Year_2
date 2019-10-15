package Tabs_view;

import Controllers.General_controller;
import Controllers.List_tab_controller;
import Other_Objects.Class_Group;
import Person_super.Person;
import Person_super.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class Listing_tab_view extends Tab {

    private Button listClass;
    private Button listTeachers;
    private Label class_select_label;
    private TextField class_select;
    private Label space;
    private Label listTeachers_label;

    private List_tab_controller list_tab_controller;


    private ListView listView;
    private ComboBox<Class_Group> comboBox;

    private Button edit;


   public Listing_tab_view(General_controller general_controller){
       this.edit = new Button("Edit");

       this.list_tab_controller = new List_tab_controller(general_controller,this);

       this.listView = new ListView<Teacher>(general_controller.getTeacherObservableList());

       this.comboBox = new ComboBox<>(general_controller.getClass_groupObservableList());
       comboBox.getSelectionModel().selectFirst();


       this.space = new Label();
       this.listTeachers_label = new Label("List all Teachers");

       this.listClass = new Button("Find");
       this.listTeachers = new Button("Find");

       this.class_select_label = new Label("Enter the name of the class you wish to list");

       this.class_select = new TextField();


       GridPane grid = new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setVgap(0);
       grid.setHgap(15.0D);


       grid.add(class_select_label,0,0);
       grid.add(comboBox,1,0);
       grid.add(listClass,2,0);

       grid.add(space,0,1);

       grid.add(listTeachers_label,0,3);
       grid.add(listTeachers,2,3);

       grid.add(listView,0,4,3,1);

       grid.add(edit,2,6);



       this.setText("Lists");
       this.setContent(grid);

       listClass.setOnAction(event -> {
           listView.setItems(FXCollections.observableList(comboBox.getSelectionModel().getSelectedItem().getStudentArrayList()));

       });

       listTeachers.setOnAction(event -> {
           listView.setItems(general_controller.getTeacherObservableList());
       });


       edit.setOnAction(event -> {
           list_tab_controller.edit((Person) listView.getSelectionModel().getSelectedItem());
       });
    }
}
