package lab_2;

public class Bicycle {
	private int Speed;
	private String Maker;
	private String type;
	
	
	
	Bicycle(){
		
	}
	
	Bicycle(int a, String b, String c) {
		
		this.Speed=a;
		this.Maker=b;
		this.type=c;
	}
	
		
		
	


	public int getSpeed() {
		return Speed;
	}


	public void setSpeed(int speed) {
		Speed = speed;
	}


	public String getMaker() {
		return Maker;
	}


	public void setMaker(String maker) {
		Maker = maker;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public void print() {
		System.out.println("Speed : " + Speed +"\nmaker:" + Maker +"\ntype: "+ type );
	}
}
