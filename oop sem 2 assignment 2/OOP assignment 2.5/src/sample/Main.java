package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Racecar> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        while (true){
            list.add( new Racecar("mustang","boss 302",1234,4321,1000,20));
        }

        //Racecar vroom = new Racecar("mustang","boss 302",1234,4321,1000,20);


       // System.out.println(vroom);

    }
}
