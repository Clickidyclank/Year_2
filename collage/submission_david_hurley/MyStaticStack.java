
/**
* ADT MyStack: Private Part<br>. 
* The class implements all the operations available in MyStack<br>
*/
public class MyStaticStack implements MyStack {	

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
		private int items[]; 
		private int numItems; 
		private int maxItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myStack is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myStack myCreateEmpty(){}

	public MyStaticStack(int m){
		this.maxItems=m;
		this.numItems=0;
		this.items=new int [this.maxItems];
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: isEmpty
	//-------------------------------------------------------------------	

	public boolean isEmpty(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (this.numItems ==0) {
			scenario =1;}
		else
			scenario = 2;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		
		case 1:
			res = true;
			
			break;
			
		case 2:
			res=false;
			
			break;
		
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get and remove first element from top of MyStack: pop
	//-------------------------------------------------------------------

	public int pop(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		if (this.numItems == 0) {
	
			scenario =1 ;
		}
		else {
			scenario = 2;
		}
			
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1: 
			System.out.println("Error there is not a number to pop");
			break;
			
			
		case 2:
			res = this.items[0];
			
			for (int i = 0; i < (this.numItems - 1); i++) {
				this.items[i] = this.items[i+1];
			}
			this.numItems = this.numItems - 1;
			
			
			break;
		}
		//---------X	--------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyStack: push
	//-------------------------------------------------------------------

	public void push(int element){
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (this.numItems==maxItems) {
			scenario = 1;
		
		}
		else if (this.numItems==0)
			scenario = 2;
		
		else
			scenario=3;
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		
		case 1:
			System.out.println("The stack is full: ERROR");
			break;
			
		case 2:
				
			this.items[0] = element;
			this.numItems = this.numItems + 1;
			System.out.println(this.items[0]);
			
			
			
			break;
			
		case 3:
			for (int i = (this.numItems-1); i >= 0; i--) {
				this.items[i+1] = this.items[i];
				}
			this.items[0] = element;
			
			this.numItems = this.numItems + 1;
			System.out.println(this.items[0]);
			
			break;
		
		}
	
			
	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyStack: print
	//-------------------------------------------------------------------

	public void print(){
		
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		
		if (this.numItems != 0) {
			scenario =1 ;
		}
		else {
			scenario =2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario) {
		case 1:
			for (int i=0; i<this.numItems; i++) {
				System.out.println(items[i]);
			}
			break;
		case 2:
			System.out.println("The stack is empty");
			break;
		}
	}
	
}
