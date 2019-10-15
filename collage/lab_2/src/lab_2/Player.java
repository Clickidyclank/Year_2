package lab_2;

public class Player {
	
	String name;
	String code;
	
	
	
	public Player (String na) {
			
			this.name=na;
			
			String IN = "";
			
			
			for (int i=0; i<name.length(); i++) {
				if (i==0) {
					char temp = name.charAt(i);
					IN = IN+temp;
				}
				else if (name.charAt(i-1)==" ".charAt(0)) {
					char temp = name.charAt(i);
					IN = IN+temp;
				}
			}
			this.code = IN;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCode() {
		return code;
	}

	
	public String toString() {
		String myString ="";
		myString = "name = " +this.name +"\n"
				+"code = "+this.code;
		
		
		return myString;
	}
	public void print() {
	 System.out.println("name = " +this.name +"\n"
				+"code = "+this.code);
	}	
}
