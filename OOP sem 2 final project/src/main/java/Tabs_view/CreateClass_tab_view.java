package Tabs_view;

import Controllers.Create_class_tab_controller;
import Controllers.General_controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CreateClass_tab_view extends Tab {


    private Create_class_tab_controller create_class_tab_controller;

    private TextField text;
    private Label label;
    private Button button;

    public CreateClass_tab_view(General_controller general_controller){

        this.create_class_tab_controller = new Create_class_tab_controller(general_controller);

        this.button = new Button("Create");
        this.text = new TextField();
        this.label = new Label("Please enter the name of the class");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(0);
        grid.setHgap(15.0D);

        grid.add(label,0,0);
        grid.add(text,1,0);
        grid.add(button,2,0);

        this.setContent(grid);
        this.setText("Create Class");

       button.setOnAction(event -> {create_class_tab_controller.createClass(text.getText());
       text.clear();
       });


    }

}
