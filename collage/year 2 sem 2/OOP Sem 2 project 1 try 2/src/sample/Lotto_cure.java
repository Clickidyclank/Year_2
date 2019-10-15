package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto_cure extends Tab {

    Main mn;


       private String message;

    private int count;
    private String reference = "";

    private ArrayList Lotto_numbers = new ArrayList();
    private ArrayList Guess_array = new ArrayList();
    private ArrayList Lotto_cure = new ArrayList();

    private TextField input1;
    private TextField input2;
    private TextField input3;
    private TextField input4;
    private TextField input5;

    private Label info;
    private Label display;
    private Button submitButton;

    Lotto_cure(Main m) {

        mn = m;

        //---------Gui---------//


        //text field
        this.input1 = new TextField();
        this.input2 = new TextField();
        this.input3 = new TextField();
        this.input4 = new TextField();
        this.input5 = new TextField();
        this.info = new Label();
        this.submitButton = new Button();
        this.display = new Label();

        //gui setup
        this.setText("Lotto Cure");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(15);

        display.setText("The range for the lottos is 1-49");

        //buttons
        this.submitButton = new Button("Submit");


        //adding them all together
        grid.add(display, 1, 1, 5, 1);
        grid.add(info, 1, 5, 5, 1);
        grid.add(input1, 0, 0, 1, 1);
        grid.add(input2, 1, 0, 1, 1);
        grid.add(input3, 2, 0, 1, 1);
        grid.add(input4, 3, 0, 1, 1);
        grid.add(input5, 4, 0, 1, 1);

        grid.add(submitButton, 2, 3, 1, 1);

        this.setContent(grid);


        Make_new_answear();


        submitButton.setOnAction(event -> {
            if (event.getSource() == submitButton) {
                submitButton();
            }


        });


    }


    public void submitButton() {
        try {


            Guess_array.add(0, Integer.parseInt(this.input1.getText()));
            Guess_array.add(1, Integer.parseInt(this.input2.getText()));
            Guess_array.add(2, Integer.parseInt(this.input3.getText()));
            Guess_array.add(3, Integer.parseInt(this.input4.getText()));
            Guess_array.add(4, Integer.parseInt(this.input5.getText()));


            for (int i = 0; i <= 4; i++) {
                for (int a = 0; a <= 4; a++) {
                    if (Guess_array.get(i) == Lotto_cure.get(a)) {
                        Lotto_cure.set(a, -1);
                        count++;
                    }


                }

            }


            if (count == 4) {
                mn.setCurrent_stars(mn.getCurrent_stars() + 4);
                mn.setGame_won(true);
                message = "You guessed 4 correctly! you get 4 stars";
                mn.Display(message);
                if (mn.getCurrent_stars() > 0) {
                    mn.List((Stage) this.getTabPane().getScene().getWindow());
                }

            }
            if (count == 5) {
                mn.setCurrent_stars(mn.getCurrent_stars() + 5);
                mn.setGame_won(true);
                message = "You guessed 5 correctly! you get 5 stars";
                mn.Display(message);
                if (mn.getCurrent_stars() > 0) {
                    mn.List((Stage) this.getTabPane().getScene().getWindow());
                }


            } else {
                info.setText("You have not guessed enough correct numbers");
            }
            clear_array();
            Make_new_answear();


        } catch (NumberFormatException nfe) {
            info.setText("That is not a valid entry. Please enter an integer");
        }
    }

    public void Make_new_answear() {
        count = 0;


        //fills the array with all possible numbers
        for (int a = 0; a <= 48; a++) {

            Lotto_numbers.add(a, a + 1);

        }

        //suffles the arraylist
        Collections.shuffle(Lotto_numbers);

        for (int a = 0; a <= 4; a++) {
            Lotto_cure.add(a, Lotto_numbers.get(a));
            reference = reference + " " + Lotto_cure.get(a);
        }

        System.out.println("The 5 numbers for game 2 are:  " + reference);
    }

    public void clear_array() {
        reference = "";

        for (int i = 0; i <= 4; i++) {

            Guess_array.remove(0);
        }
    }


}
