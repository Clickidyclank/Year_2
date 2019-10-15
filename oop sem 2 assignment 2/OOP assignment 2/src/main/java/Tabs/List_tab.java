package Tabs;

import Controllers.GeneralController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import sample.Car;

public class List_tab extends Tab {



    private Label label;
    private Button natural;
    private Button year;
    private Button mileage;
    private ListView listview;

   public List_tab( GeneralController generalController){

        this.listview = new ListView(generalController.getCarObList());

        this.label = new Label("Please click the button which you want the cars sorted by");
        this.natural = new Button("Natural");
        this.year = new Button("Year");
        this.mileage = new Button("milage");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(15);


        grid.add(label,0,0);
        grid.add(natural,0,1);
        grid.add(year,0,2);
        grid.add(mileage,0,3);
        grid.add(listview, 0,4);


        this.setText("List view");
        this.setContent(grid);


        natural.setOnAction(event -> generalController.getCarObList().sort(Car::compareTo));

        year.setOnAction(event -> generalController.getCarObList().sort(Car::yearCompare));

        mileage.setOnAction(event -> generalController.getCarObList().sort(Car::millageCompare));

    }
}
