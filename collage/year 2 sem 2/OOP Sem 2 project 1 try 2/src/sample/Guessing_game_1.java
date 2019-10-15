package sample;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


class Guessing_game_1 extends Tab {
    Main mn;


    //declaring starting attributes
    private String message;
    private int randomNumber = generateNewNumber();
    private int guessNo;
    private int game_1_wins_count = 0;
    private TextField userInput_game_1;
    private Label info;
    private Label guessNoDisplay;
    private Button submitButton;
    private Button quitButton;
    private Button resetButton;


    Guessing_game_1(Main m) {
        mn = m;

        // GUI elements for game 1
        //labels and grid
        this.guessNoDisplay = new Label("The number is between 1 and 50. You get 4 guesses. Good luck.");
        this.info = new Label("");


        this.setText("Guessing Game");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(5);
        grid.setHgap(15);

        //buttons
        this.submitButton = new Button("Submit Guess");
        this.resetButton = new Button("Reset");
        this.quitButton = new Button("Quit");

        //text field
        this.userInput_game_1 = new TextField();
        userInput_game_1.setMaxWidth(100);


        //adding them all together
        grid.add(guessNoDisplay, 0, 0, 3, 1);
        grid.add(info, 0, 1);
        grid.add(userInput_game_1, 0, 5, 2, 1);
        grid.add(submitButton, 0, 6, 1, 1);
        grid.add(resetButton, 0, 7, 1, 1);
        grid.add(quitButton, 0, 8, 1, 1);

        this.setContent(grid);

        //-----------logic------------//
        //Submit button
        submitButton.setOnAction(event -> {

            submitButton();

            if (mn.getCurrent_stars() > 0) {
                mn.List((Stage) this.getTabPane().getScene().getWindow());
            }

        });


        //Reset button
        resetButton.setOnAction(event -> {
            if (event.getSource() == resetButton) {
                resetButton();
            }

        });

        //Quit button
        quitButton.setOnAction(event -> ((Stage) this.getTabPane().getScene().getWindow()).close());

    }

    private void submitButton() {
        try {
            int guess = Integer.parseInt(this.userInput_game_1.getText());
            if (guess >= 1 && guess <= 50) {
                if (guess == randomNumber) {
                    game_1_wins_count++;

                    mn.setGame_won(true);
                    if (game_1_wins_count > 4) {
                        mn.setCurrent_stars(mn.getCurrent_stars() + 3);
                        message = "You guessed correctly. you won 3 stars";

                    } else {
                        mn.setCurrent_stars(mn.getCurrent_stars() + 2);
                        message = "You guessed correctly you won 2 stars";

                    }
                    resetButton();

                    mn.Display(message);

                } else if (guess < randomNumber) {
                    guessNo++;
                    info.setText("Incorrect, your guess is too low. You have " + (4 - guessNo) + " remaining guesses.");
                } else {
                    guessNo++;
                    info.setText("Incorrect, your guess is too high. You have " + (4 - guessNo) + " remaining guesses.");
                }
            } else {
                info.setText("That is not within the range");
            }
            } catch (NumberFormatException nfe) {
                info.setText("That is not a valid entry. Please enter an integer withing the range");

        }

        if (guessNo == 4) {
            game_1_wins_count = 0;
            message = "You have run out of guesses";
            mn.Display(message);
            resetButton();
        }

    }

    private void resetButton() {
        info.setText("The game has been restarted");
        guessNo = 0;
        generateNewNumber();

    }

    public int generateNewNumber() {
        //we use this method to generate our random number
        randomNumber = (int) (Math.random() * 49 + 1);
        System.out.println("The random number for game 1 is : " + randomNumber);

        return randomNumber;
    }


}