package Tabs;

import Controllers.GeneralController;
import Controllers.Remove_tab_controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Remove_tab extends Tab {


private Button remove;
private TextField reg_num;
private Label label;
private Label info;

private GeneralController generalController;
  public  Remove_tab( GeneralController generalController){

        this.generalController = generalController;

        this.label = new Label("Please enter the registration number of the car you wish to remove");
        this.reg_num = new TextField();
        this.remove = new Button("Remove car");

        Remove_tab_controller remove_tab_controller = new Remove_tab_controller(generalController ,this);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(15);


        grid.add(label,0,0);
        grid.add(reg_num,0,1);
        grid.add(remove,0,2);


        this.setText("Remove car");
        this.setContent(grid);


        remove.setOnAction(event -> {

            if(event.getSource()==remove){
                remove_tab_controller.remove(Integer.parseInt(reg_num.getText()));
            }

        });


    }



}
