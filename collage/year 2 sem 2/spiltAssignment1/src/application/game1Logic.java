package application;

public class game1Logic {

	//Game 1 code variables
	private int randomNumber = generateNewNumber();
	private int guessNumber = 0;
	private int G1VictoryCount = 0;
	private boolean gamePassed = false;

	Main mn;

	game1Logic(Main m){
		// creates a call back method so I can access the mains methods
		mn = m;
		System.out.println("Here is the Random number for game 1: " + randomNumber);
	}

	public int generateNewNumber() {
		//Generating a random number
		randomNumber = (int)(Math.random() * 50 + 1);
		return randomNumber;
	}

	public int getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getG1VictoryCount() {
		return G1VictoryCount;
	}

	public void setG1VictoryCount(int g1VictoryCount) {
		G1VictoryCount = g1VictoryCount;
	}

	public int getGuessNumber() {
		return guessNumber;
	}

	public void setGuessNumber(int guessNumber) {
		this.guessNumber = guessNumber;
	}

	public void onClickReset() {
		//Setting up the Reset button in tab 1
		// Generates a new random number, resets the guess number and clear's the text field
		generateNewNumber();
		mn.UnHideButton(mn.getButtonSubGuess());
		System.out.println("New random number: " + randomNumber);
		resetGuessNumber();

		mn.reset(mn.getuserInput(), mn.getGuessNoDiplay());
	}

	public void onClickSubmit () {
		// checking to see if the guess is correct.
		// and it changes the appropriate variables to track victories and resets.
		
		if (mn.getSavedValue() == randomNumber) {
			mn.getL2().setText("Correct! You've won two stars. ");
			guessNumber +=1;
			G1VictoryCount +=1;
			gamePassed = true;

			// hides the text filed and buttons
			mn.hideButton(mn.getButtonSubGuess());
			mn.deactivateTextField(mn.getuserInput());
			
			// checking to see if they won 5 in a row or not
			if (G1VictoryCount % 5 == 0) {
				mn.setStarNumber(mn.getStarNumber() + 3);
			}
			else {
				mn.setStarNumber(mn.getStarNumber() + 2);
			}
			//updates the guess display labels
			mn.upDateGuessDisplayLabel();
		}
		//outputs that the user is wrong and changes the guess number
		else if(mn.getSavedValue() < randomNumber){
			mn.getL2().setText("Wrong. Your guess is too low.");
			guessNumber += 1;
			if (guessNumber == 4) {
				mn.deactivateTextField(mn.getuserInput());
			}
			//updates the guess display labels
			mn.upDateGuessDisplayLabel();
		}

		//outputs that the user is wrong and changes the guess number
		else if(mn.getSavedValue() > randomNumber) {
			mn.getL2().setText("Wrong. Your guess is too high.");
			guessNumber += 1;
			if (guessNumber == 4) {
				mn.deactivateTextField(mn.getuserInput());
			}
			//updates the guess display labels
			mn.upDateGuessDisplayLabel();
		}

		//If they passed the game and have stars it adds on the third tab.
		if (mn.getStarNumber() >= 1 && gamePassed == true) {
			mn.addTab3(mn.getListView(), mn.getHashTable());
		}

		//outputs that the user has to reset, if they have used up all four guesses.
		if(guessNumber >= 4) {
			G1VictoryCount = 0;
			mn.getL2().setText("You've used all your guesses please press restart to try again.");
			mn.hideButton(mn.getButtonSubGuess());
		}
		// Sets the game passed variable to false.
		gamePassed = false;
	}

	public int resetGuessNumber() {
		//Resets the guess number variable to zero and then returns it.
		guessNumber = 0;
		return guessNumber;
	}
}
