
/**
 * ADT MyStack: Private Part<br>
 * . The class implements all the operations available in MyStack<br>
 */
public class MyDoubleDynamicStack<T> implements MyStack<T> {

	// --------------------------------------------------
	// Attributes
	// --------------------------------------------------
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;
	private int numItems;
	// -------------------------------------------------------------------
	// Basic Operation --> Check if myStack is empty: myCreateEmpty
	// -------------------------------------------------------------------
	// public myStack myCreateEmpty(){}

	public MyDoubleDynamicStack() {

		head = null;
		tail = null;
		this.numItems = 0;

	}

	// -------------------------------------------------------------------
	// Basic Operation --> Check if myStack is empty: isEmpty
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

		if (numItems == 0) {
			scenario = 1;
		}

		else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {

		case 1:
			System.out.println("The stack is empty");
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
	// Basic Operation (Partial) --> Get first element from front of MyStack: first
	// -------------------------------------------------------------------

	public T first() {
		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		T res = null;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
		case 1:
			System.out.println("The stack is empty");
			res = null;
			break;

		case 2:
			res = this.head.getInfo();
			break;
		}
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}

	// -------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyStack: addByFirst
	// -------------------------------------------------------------------

	public void addByFirst(T element) {
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		MyDoubleLinkedNode<T> newNode = new MyDoubleLinkedNode<T>(null, element, null);
		switch (scenario) {
		case 1:
			this.head = newNode;
			this.tail = newNode;
			numItems = numItems + 1;
			break;
		case 2:
			this.head.setLeft(newNode);
			newNode.setRight(this.head);
			this.head = newNode;
			numItems = numItems + 1;
			break;
		}
	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyStack:
	// removeByFirst
	// -------------------------------------------------------------------

	public void removeByFirst() {
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else if (this.numItems > 1) {
			scenario = 2;
		}

		else if (this.numItems == 1) {
			scenario = 3;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
		case 1:
			System.out.println("There is no items to remove");
			break;
		case 2:
			this.head.getLeft();
			numItems = numItems - 1;
			break;
		case 3:
			this.head = null;
			this.tail = null;
			this.numItems = 0;
			break;

		}
	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyStack: last
	// -------------------------------------------------------------------

	public T last() {
		// -----------------------------
		// Output Variable --> InitialValue
		// -----------------------------
		T res = null;

		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
		case 1:
			System.out.println("The stack is empty ");
			break;

		case 2:
			res = this.tail.getInfo();
			break;
		}
		// -----------------------------
		// Output Variable --> Return FinalValue
		// -----------------------------
		return res;
	}

	// -------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyStack: addByLast
	// -------------------------------------------------------------------

	public void addByLast(T element) {
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else {
			scenario = 2;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		MyDoubleLinkedNode<T> newNode = new MyDoubleLinkedNode<T>(null, element, null);
		switch (scenario) {
		case 1:
			this.head = newNode;
			this.tail = newNode;
			break;
		case 2:
			newNode.setRight(tail);
			this.tail = newNode;
			numItems = numItems + 1;
			break;
		}
	}

	// -------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyStack:
	// removeByFirst
	// -------------------------------------------------------------------

	public void removeByLast() {
		// -----------------------------
		// SET OF OPS
		// -----------------------------

		// -----------------------------
		// I. SCENARIO IDENTIFICATION
		// -----------------------------
		int scenario = 0;

		if (this.numItems == 0) {
			scenario = 1;
		}

		else if (this.numItems > 1) {
			scenario = 2;
		}

		else {
			scenario = 3;
		}
		// -----------------------------
		// II. SCENARIO IMPLEMENTATION
		// -----------------------------
		switch (scenario) {
		case 1:
			System.out.println("The stack is empty");
			break;
			
		case 2:
			this.tail =this.tail.getLeft();
			//this.tail.setRight(null);
			numItems=numItems-1;
			break;
		case 3:
			this.tail = this.tail.getLeft();
			this.tail=null;
			this.head=null;
			numItems=0;
			break;
			
		}
	}

}
