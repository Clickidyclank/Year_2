package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import sample.Car;

import java.io.*;
import java.util.ArrayList;

public class GeneralController {

    //The general controller class is how we are able to interact with out observable list from each of our tabs.

    private ArrayList<Car> CarList;


    public GeneralController() {

        try {

            //this is how we read our list on start up
            ObjectInputStream read = new ObjectInputStream(new FileInputStream( "savedCars.txt"));
            ArrayList arrayList = (ArrayList)read.readObject();
            carObList = FXCollections.observableList(arrayList);

        } catch (EOFException e) {
            //empty file erro
            carObList = FXCollections.observableList(new ArrayList<>());
            e.printStackTrace();
            Alert eofAlert = new Alert(Alert.AlertType.INFORMATION);
            eofAlert.setTitle("End of File");
            eofAlert.setHeaderText("End of File");
            eofAlert.setContentText("The save file contains no data.");
            eofAlert.showAndWait();
        } catch (IOException e) {
            //io error
            carObList = FXCollections.observableList(new ArrayList<>());
            e.printStackTrace();
            Alert ioAlert = new Alert(Alert.AlertType.INFORMATION);
            ioAlert.setTitle("I/O Alert");
            ioAlert.setHeaderText("I/O Alert");
            ioAlert.setContentText("The save file may be corrupted.");
            ioAlert.showAndWait();
        } catch (ClassNotFoundException e) {
            //class error
            e.printStackTrace();
            Alert classAlert = new Alert(Alert.AlertType.INFORMATION);
            classAlert.setTitle("Class Not Found");
            classAlert.setHeaderText("Class not found");
            classAlert.setContentText("The save file contains the wrong class type objects.");
            classAlert.showAndWait();
        }





    }



    public ObservableList<Car> getCarObList() {
        return carObList;
    }

    public void setCarObList(ObservableList<Car> carObList) {
        this.carObList = carObList;
    }

    private ObservableList<Car> carObList;

    public ArrayList<Car> getCarList() {
        return CarList;
    }

    public void setCarList(ArrayList<Car> carList) {
        CarList = carList;
    }


}
