package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*

    hashmap -
    obeserable list
    read in from file
    extend from main to access stars

*/

public class Prize_list extends Tab {

    private Button selectButton;
    private Label label;
    Main mn;

    Prize_list(Main mn) {

        //make elements
        this.selectButton = new Button("Select");
        Label label = new Label("Select a prize!");


        //
        this.setText("Prizes");
        //make gridpane
        GridPane gridPane = new GridPane();

        gridPane.add(mn.getListView(), 0, 1, 5, 3);
        gridPane.add(label, 0, 0, 5, 1);
        gridPane.add(selectButton, 5, 3);


        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(15);

        // Set Content
        this.setContent(gridPane);




        selectButton.setOnAction(event -> {
            if (event.getSource()==selectButton){
                selectButton(mn.getListView());
            }
            mn.List((Stage) this.getTabPane().getScene().getWindow());


        });


    }

    public void selectButton(ListView listView){
        String boxString = (String) listView.getSelectionModel().getSelectedItem();
        System.out.println(boxString);
        int cost = Integer.parseInt(mn.hashMap.get(boxString)[0]);
        System.out.println(cost);

        String message ="Congrats you have won a : "+mn.hashMap.get(boxString)[1];


        Alert game_won = new Alert(Alert.AlertType.INFORMATION);
        game_won.setContentText(String.format(message));
        game_won.setTitle("");
        game_won.setHeaderText("");
        game_won.showAndWait();


        System.out.print(mn.hashMap.get(boxString)[1]);
        ((Stage) this.getTabPane().getScene().getWindow()).close();


    }

   }



