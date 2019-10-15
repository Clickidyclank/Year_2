
/**
 * ADT MyStack: Private Part<br>
 * . The class implements all the operations available in MyStack<br>
 */
public class MyDynamicStack implements MyStack {

	private MyNode head;
	private int numItems = 0;
	// --------------------------------------------------
	// Attributes
	// --------------------------------------------------

	// ------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: myCreateEmpty
	// -------------------------------------------------------------------
	// public myStack myCreateEmpty(){}

	public MyDynamicStack() {

		this.head = null;
		this.numItems = 0;

	}
	// -------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: isEmpty
	// -------------------------------------------------------------------

	public boolean isEmpty() {
		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		boolean res = true;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		} else
			scenario = 2;
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

		case 1:
			res = true;

			break;

		case 2:
			res = false;

			break;
		}
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from the top of MyStack and
	// removes it: pop
	// -------------------------------------------------------------------

	public int pop() {
		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		int res = -1;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {

			scenario = 1;
		} else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
		case 1:

			System.out.println("There are no items in the stack");

			break;
		case 2:
			res = this.head.getInfo();
			this.head = this.head.getNext();
			this.numItems = this.numItems - 1;
			break;
		}
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyStack: push
	// -------------------------------------------------------------------

	public void push(int element) {
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;
		if (this.numItems == 0) {

			scenario = 1;
		} else {
			scenario = 2;
		}

		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		MyNode newNode = null;
		MyNode currentNode = null;
		MyNode emptyNode = null;

		switch (scenario) {
		
		case 1:
			
			currentNode = head;
			
			emptyNode = new MyNode(element, null);

			this.head = emptyNode;

			

			emptyNode.setNext(currentNode);

			numItems++;
			break;

		case 2:
			currentNode = head;
			
			newNode = new MyNode(element, this.head);

			this.head = newNode;

			
			newNode.setNext(currentNode);

			numItems++;
			break;
		}

	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyStack: print
	// -------------------------------------------------------------------

	public void print() {

		// -----------------------------
		// SET OF OPS
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		} else {
			scenario = 2;
		}
		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		switch (scenario) {
		case 1:
			System.out.println("The stack is empty.");
			break;
		case 2:
			MyNode i = this.head;
			System.out.print("[");
			while (i != null) {
				if (i.getNext() != null) {
					System.out.print(i.getInfo() + ", ");
					i = i.getNext();
				} else {
					System.out.print(i.getInfo() + "]");
					break;
				}
			}
			// -----------------------------
			// II. SCENARIO IMPLEMENTATION
			// -----------------------------

		}

	}
}
