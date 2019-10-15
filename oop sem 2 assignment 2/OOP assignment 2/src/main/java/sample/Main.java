package sample;

import Controllers.GeneralController;
import Tabs.Add_tab;
import Tabs.List_tab;
import Tabs.Remove_tab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main extends Application {


   // private ArrayList<Car> CarList = new ArrayList<>();



    @Override
    public void start(Stage primaryStage) throws Exception{

    GeneralController generalController = new GeneralController();

        TabPane tabPane = new TabPane();
        Add_tab add = new Add_tab(generalController);
        Remove_tab remove = new Remove_tab(generalController);
        List_tab list = new List_tab(generalController);



        //adding tabs to tabpane
        tabPane.getTabs().addAll(add,remove,list);

        //removes close button
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //stage and scene setup
        Scene scene = new Scene(tabPane, 600, 600, Color.BLACK);
        primaryStage.setTitle("Project 2 - Cars.");
        primaryStage.setScene(scene);

        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {

            //The lines below are how we save our object list to our file.
            //we first make an array list and fill it with out observable list


            try {
                ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("savedCars.txt"));
                ArrayList<Car> carArrayList = new ArrayList<>(generalController.getCarObList());
                save.writeObject(carArrayList);

                System.out.println("Saved");
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
