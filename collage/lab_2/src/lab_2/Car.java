package lab_2;

public class Car {
	private int age;
	private float price;
	private String name;

	public Car(int age, float price, String name) {

		this.name = name;
		this.age = age;
		this.price = price;

	}

	public void Desc(int age) {
		if (this.age<3)
			System.out.println(this.name+ " is " + this.age +" years old and is shiny new");
		else if (this.age<6)
			System.out.println(this.name+ " is " + this.age +" years old and is slightly worn");
		else if (this.age<8)
			System.out.println(this.name+ " is " + this.age +" years old and is past its best ");
		else if (this.age<10)
			System.out.println(this.name+ " is " + this.age +" years old and is shows signs of its age ");	
		else 
			System.out.println(this.name+ " is " + this.age +" years old and is a banger");
		
		
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {

		return name + " " + age + " " + price;
	}

	public void print() {
		Desc(this.age);
		System.out.println(name + " " + age + " " + price);
	}
}
