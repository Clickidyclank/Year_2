import Controllers.General_controller;
import Tabs_view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{
        General_controller general_controller = new General_controller(primaryStage);

        TabPane tabPane = new TabPane();
        Add_remove_student_tab_view add_remove = new Add_remove_student_tab_view(general_controller);
        Listing_tab_view list = new Listing_tab_view(general_controller);
        CreateClass_tab_view cct = new CreateClass_tab_view(general_controller);




        tabPane.getTabs().addAll(add_remove,cct,list);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);




        primaryStage.setTitle("Database");
        primaryStage.setScene(new Scene(tabPane, 1500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
