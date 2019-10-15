package application;

public class game2Logic {

	// Creating the random number variables
	private int randomNumber1 = generateLottoNumbers();
	private int randomNumber2 = generateLottoNumbers();
	private int randomNumber3 = generateLottoNumbers();
	private int randomNumber4 = generateLottoNumbers();
	private int randomNumber5 = generateLottoNumbers();

	//sets the gamePassed variable to false.
	private boolean gamePassed = false;

	private int correctNums = 0; 

	// creates an Intger Array that is null
	private int[] IntegerArray = null;

	Main mn;

	game2Logic(Main m){
		// creates a call back method so I can access the mains methods
		mn = m;
		System.out.println("Lotto Numbers: [" + randomNumber1 +","+ randomNumber2 +","+ randomNumber3 +","+ randomNumber4 +","+ randomNumber5+"]");
	}

	private int generateLottoNumbers() {
		// Generating a number from [1-9]
		int randomLottoNumber = (int)(Math.random()* 9 + 1);
		return randomLottoNumber;
	}	


	public void onClickSubmit() {
		int[] IntegerArray = null;
		IntegerArray = mn.passInLottoTextField();

		// Checks the textfield number against the generated lotto numbers
		if(randomNumber1 == IntegerArray[0]) {
			correctNums +=1;
		} 
		if (randomNumber2 == IntegerArray[1]) {
			correctNums +=1;
		} 
		if (randomNumber3 == IntegerArray[2]) {
			correctNums +=1;
		}
		if (randomNumber4 == IntegerArray[3]) {
			correctNums +=1;
		}  
		if (randomNumber5 == IntegerArray[4]) {
			correctNums +=1;
		}

		// Reads in the number of correct/incorrect numbers and outputs the right message. 
		if (correctNums == 5) {
			mn.getL4().setText("All numbers are Correct.");
			gamePassed = true;
			//hides the button and text fields
			mn.deactivateTextField(mn.getuserInputG2());
			mn.hideButton(mn.getButtonSubmitLotto());
			//increases the star number
			mn.setStarNumber(mn.getStarNumber()+5);
		}
		else if (correctNums == 4) {
			gamePassed = true;
			//changes the label to inform the user of the result.
			mn.getL4().setText("Four out of five numbers are correct.");
			//hides the button and text fields
			mn.deactivateTextField(mn.getuserInputG2());
			mn.hideButton(mn.getButtonSubmitLotto());
			//increases the star number
			mn.setStarNumber(mn.getStarNumber()+4);
		}
		else
			//changes the label to inform the user of the result.
			mn.getL4().setText("The numbers are not correct");
		// clears the text field.
		mn.clearTextField(mn.getuserInputG2());

		//If they passed the game and have stars it adds on the third tab.
		if (mn.getStarNumber() > 1 && gamePassed == true) {
			mn.addTab3(mn.getListView(), mn.getHashTable());
		}								
		// sets game passed to false.
		gamePassed = false;
	}

	public void generateNewLottoNums() {
		// Generates new lotto numbers
		randomNumber1 = generateLottoNumbers();
		randomNumber2 = generateLottoNumbers();
		randomNumber3 = generateLottoNumbers();
		randomNumber4 = generateLottoNumbers();
		randomNumber5 = generateLottoNumbers();
	}

	public void outputNewNums() {
		System.out.println("New Lotto Numbers: [" + randomNumber1 +","+ randomNumber2 +","+ randomNumber3 +","+ randomNumber4 +","+ randomNumber5+"]");
	}

}
