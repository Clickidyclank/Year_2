package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.UIManager.put;


public class Main extends Application {
    //Declaring starting variables:
    //int stars = 0;
    private int current_stars = 0;
    private boolean game_won = false;
   static HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
    private ListView<String> listView = new ListView<>();


    Prize_list tab3 = new Prize_list(this);


    @Override
    public void start(Stage primaryStage) throws Exception {


        //creating tabpane to hold tabs
        TabPane tabPane = new TabPane();

        //making the games
        Guessing_game_1 game1 = new Guessing_game_1(this);
        Lotto_cure game2 = new Lotto_cure(this);



        //------------Gui-------------//


        //adding tabs to tabpane
        tabPane.getTabs().addAll(game1, game2,tab3);

        //removes close button
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        //stage and scene setup
        Scene scene = new Scene(tabPane, 600, 600, Color.BLACK);
        primaryStage.setTitle("Project 1 - Game.");
        primaryStage.setScene(scene);
        tab3.setDisable(true);


        primaryStage.show();

    }

    public void List(Stage stage) {



        //sets tab to be clickable
        if (game_won=true){
            tab3.setDisable(false);
        }

           //makes prizelist and reads the file
        stage.setTitle(String.format("Star count : %d", this.getCurrent_stars()));
        List<String> prizeList = new ArrayList<>();
        File file = new File("C:\\Users\\David\\Desktop\\OOP Sem 2 project 1 try 2\\src\\sample\\Prizes");
        try {
            prizeList = Files.readAllLines(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Makes HashMap
        hashMap = new HashMap<>();

        //Itterates through prizelist filling cost prize
        for (String s : prizeList) {
            String[] costPrize = {s.split(":")[1], s.split(":")[2]};
            //puts it into the hashmap
            hashMap.put((s.split(":")[0]), costPrize);
        }


        //makes our arrayList keys and fruit
        ArrayList<String> keys = new ArrayList<>(hashMap.keySet());
        ArrayList<String> fruit = new ArrayList<>();


        for (int i = 0; i < hashMap.size(); i++) {
            if (Integer.parseInt(hashMap.get(keys.get(i))[0]) <= this.getCurrent_stars()) {
                fruit.add(keys.get(i));
            }

            //sets it to be viewable
            ObservableList<String> observableList;
            observableList = FXCollections.observableList(fruit);
            listView.setItems(observableList);


        }
    }

    public void Display(String message) {


        Alert game_won = new Alert(Alert.AlertType.INFORMATION);
        game_won.setContentText(String.format(message));
        game_won.setTitle("");
        game_won.setHeaderText("");
        game_won.showAndWait();
    }


    public int getCurrent_stars() {
        return current_stars;
    }

    public void setCurrent_stars(int current_stars) {
        this.current_stars = current_stars;
    }

    public boolean isGame_won() {
        return game_won;
    }

    public void setGame_won(boolean game_won) {
        this.game_won = game_won;
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public HashMap<String, String[]> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String[]> hashMap) {
        this.hashMap = hashMap;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
