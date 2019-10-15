package Tabs;

import Controllers.Add_tab_controller;
import Controllers.GeneralController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * GUI for the add tab.
 */
public class Add_tab extends Tab {



    private TextField make;
    private TextField model;
    private TextField year;
    private TextField reg_num;
    private TextField mileage;
    private Label Lmake;
    private Label Lmodel;
    private Label Lyear;
    private Label Lreg_num;
    private Label Lmileage;
    private Button add;
    private Label info;
    private GeneralController generalController;

   public Add_tab(GeneralController generalController) {



        this.generalController = generalController;
        this.make = new TextField();
        this.model = new TextField();
        this.year = new TextField();
        this.reg_num = new TextField();
        this.mileage = new TextField();
        this.Lmake = new Label("Please enter the make of the car");
        this.Lmodel = new Label("Please enter the model of the car");
        this.Lyear = new Label("Please enter the year of the car");
        this.Lreg_num = new Label("Please enter the reg num of the car");
        this.Lmileage = new Label("Please enter the mileage of the car");
        this.add = new Button("Add");
        this.info = new Label();

        Add_tab_controller add_tab_controller = new Add_tab_controller(generalController,this);





        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(15);

        grid.add(Lmake, 0, 0);
        grid.add(make, 0, 1);

        grid.add(Lmodel, 0, 3);
        grid.add(model, 0, 4);

        grid.add(Lyear, 0, 6);
        grid.add(year, 0, 7);

        grid.add(Lreg_num, 0, 9);
        grid.add(reg_num, 0, 10);

        grid.add(Lmileage, 0, 12);
        grid.add(mileage, 0, 13);

        grid.add(add, 0, 15);

        grid.add(info, 0, 17);

        this.setText("Add Car");

        this.setContent(grid);


        add.setOnAction(event -> {

            if (event.getSource() == add) {
               add_tab_controller.add(this.make.getText(),this.model.getText(),this.mileage.getText(),this.year.getText(),this.reg_num.getText());
               this.make.clear();
               this.model.clear();
               this.year.clear();
               this.reg_num.clear();
               this.mileage.clear();
            }
        });


    }


    public void setInfo(String info) {
        this.info.setText(info);
    }
}
