package application;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.HashMap;
import java.util.Hashtable;

public class Main extends Application {
	// ints to track the stars and to pass in a user input to game 2
	private int starNumber = 0;
	private int savedValue = 0;

	// Creating an instance of the game1 class
	game1Logic game1 = new game1Logic(this);
	// Creating an instance of the game2 class
	game2Logic game2 = new game2Logic(this);
	// Creating an instance of the prize controller class
	prizeController game3 = new prizeController(this);

	//AlertBox AB = new AlertBox(this);

	//--------------------------------GUI elements--------------------------------------
	//Adding tabs
	private Tab tab1 = new Tab("Random Number Game");
	private Tab tab2 = new Tab("Lotto Cure");
	private Tab tab3 = new Tab("Collect Prizes");

	// Adding in a tabPane to hold the tabs
	private TabPane tabPane = new TabPane();

	// Adding a vertical layout
	private VBox vbox = new VBox();

	// GUI elements for game 1
	// Bunch of labels
	private Label guessNoDiplay = new Label(game1.getGuessNumber() + " out of 4");
	private Label l1 = new Label ("");
	private Label l2 = new Label ("");
	// Three buttons 
	private Button buttonSubGuess = new Button("Submit Guess");
	private Button resetButton = new Button("Reset");
	private Button exitButton = new Button("Exit");
	// The text field 
	private TextField userInput = new TextField();


	//GUI components for game 2.

	// The text field 
	private TextField userInputG2 = new TextField();
	// The submit button.
	private Button buttonSubmitLotto = new Button("Submit Numbers");
	// Pair of labels
	private Label l3 = new Label ("");
	private Label l4 = new Label ("");

	//GUI components for the prize tab.
	//The button
	private Button testButton = new Button("Select Prize");
	// Creating the hash table and the list view
	private ListView<String> listView = new ListView<>();
	private Hashtable< String, String > hash = new Hashtable< String, String >();

	// Code that turns it into an application
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		//Setting the primary Stage to be a window 
		Stage window = primaryStage;
		//Set the window title
		window.setTitle("Star Count : 0");

		// Creating GUI elements
		Group root = new Group();
		Scene scene = new Scene(root, 400, 250, Color.WHITE);
		BorderPane borderPane = new BorderPane();

		// -----------The First Tab-------------------------
		//Setting up the visuals


		// adding the GUI elements to the vertical layout
		vbox.getChildren().add(guessNoDiplay);
		vbox.getChildren().add(l1);
		vbox.getChildren().add(l2);
		vbox.getChildren().add(userInput);
		vbox.getChildren().add(buttonSubGuess);
		vbox.getChildren().add(resetButton);
		vbox.getChildren().add(exitButton);

		// aligning
		vbox.setAlignment(Pos.CENTER);
		// Setting the buttons and other GUI components on teh tabs
		tab1.setContent(buttonSubGuess);
		tab1.setContent(userInput);
		tab1.setContent(resetButton);
		tab1.setContent(exitButton);
		tab1.setContent(vbox);


		// Once the game 1 reset button is clicked
		resetButton.setOnAction(e -> {
			// Generates a new random number, resets the guess number and clear's the text field
			game1.onClickReset();
		});

		//Setting up the guess button in tab 1
		buttonSubGuess.setOnAction(e -> { 
			parseUserTextField();
			game1.onClickSubmit();
			window.setTitle("Star Count : " + starNumber);
		});

		exitButton.setOnAction(e -> window.close());

		// -----------The Second Tab-------------------------

		//Creating the layout and adding elements to it.
		// H box layout
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(userInputG2, buttonSubmitLotto );

		// V box layout
		VBox vbox3 = new VBox();
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setSpacing(20);
		vbox3.getChildren().addAll(l4,l3, hbox);

		//Setting the GUI components onto the layout
		tab2.setContent(vbox3);

		buttonSubmitLotto.setOnAction(e -> {
			game2.onClickSubmit();
			window.setTitle("Star Count : " + starNumber);
		});

		// -----------The Third Tab-------------------------
		// Creating the essentials for making a list view

		// Sets the selection model of the list view  
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		// GUI components for the prize tab.
		// Creates and sets the components for the layout. 
		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);	

		hbox2.setPadding(new Insets (20 ,20 ,20 ,20));
		hbox2.getChildren().addAll(listView, testButton);

		tab3.setContent(hbox2);


		testButton.setOnAction(e -> {
			try {

				// Creates a new dialog box & sets its type
				Dialog prizeAlert = new Alert(Alert.AlertType.INFORMATION);
				prizeAlert.setTitle("Please confirm");
				// Gets the clicked item and converts it to a string.
				String result = listView.getSelectionModel().getSelectedItem().toString();
				// Gets the selected items hash table value and outputs it in the box.
				prizeAlert.setContentText("Here is your prize: " + hash.get(result));
				prizeAlert.show();

				//game3.onClick(listView,);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			window.close();
		});

		//Adds all 3 tabs
		tabPane.getTabs().addAll(tab1,tab2);

		//Makes the tabs scale to the available space
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());

		borderPane.setCenter(tabPane);
		root.getChildren().add(borderPane);

		window.setScene(scene);
		window.show();

	}

	public void reset (TextField tf, Label lb) {
		// Clear the text field
		tf.clear();

		//Resets the guess number display
		lb.setText(game1.getGuessNumber() + " out of 4");

		//Allows the bar to be seen again
		userInput.setEditable(true);
		userInput.setVisible(true);
	}

	public void deactivateTextField(TextField tf) {
		//disables the text field
		tf.setEditable(false);
		tf.setVisible(false);
	}

	public void parseUserTextField() {
		boolean correct = true;
		try {
			savedValue = Integer.parseInt(userInput.getText());
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
	}

	public void upDateGuessDisplayLabel() {
		guessNoDiplay.setText(game1.getGuessNumber() + " out of 4");
	}

	public void addTab3(ListView listView, Hashtable hash) {
		tabPane.getTabs().add(tab3);
		game3.populateTheList(listView, hash);
		tabPane.getTabs().add(tab3); 
	}

	public int getSavedValue() {
		return savedValue;
	}

	public int[] passInLottoTextField() {
		System.out.println("you must enter a value.");
		//Parsing the user input from game 2 into a String array.
		String StringArray[] = userInputG2.getText().split("\\B");

		//Creating a new int array the size of the String array. 
		int IntegerArray[] = new int[StringArray.length];

		for (int i = 0; i < StringArray.length; i++) {
			IntegerArray[i] = Integer.parseInt(StringArray[i]);
			//System.out.print(" "+ IntegerArray[i]);
		}
		return IntegerArray;
	}

	public void clearTextField(TextField tf) {
		tf.clear();
	}

	public void hideButton(Button btn) {
		btn.setVisible(false);
	}

	public void UnHideButton(Button btn) {
		btn.setVisible(true);
	}

	public int getStarNumber() {
		return starNumber;
	}

	public void setStarNumber(int s) {
		starNumber = s;
	}

	public ListView<String> getListView (){
		return listView;
	}

	public Hashtable<String, String> getHashTable(){
		return hash;
	}

	public Button getButtonSubGuess() {
		return buttonSubGuess;
	}

	public Button getButtonSubmitLotto() {
		return buttonSubmitLotto;
	}

	public TextField getuserInput () {
		return userInput;
	}

	public TextField getuserInputG2 () {
		return userInputG2;
	}

	public Tab getTab3() {
		return tab3;
	}

	public Label getGuessNoDiplay() {
		return guessNoDiplay;
	}

	public Button getTestButton() {
		return testButton;
	}

	public Label getL2() {
		return l2;
	}

	public void setL2(Label l2) {
		this.l2 = l2;
	}

	public Label getL4() {
		return l4;
	}

	public void setL4(Label l4) {
		this.l4 = l4;
	}

}
