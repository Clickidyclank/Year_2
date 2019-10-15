package lab_2;

public class TestBike
{
    public static void main(String[] args)
    {
        Bicycle  bike1 = new Bicycle(); // This line constructs the object bike1
        bike1.setSpeed(100); // this sets the argument for speed to 100
        bike1.setMaker("Raleigh");
        bike1.setType("Mountain Bike");
        bike1.print();
        
        Bicycle bike2 = new Bicycle(10,"Home Made", "Bone Shaker");
        bike2.print();//needs to be changed to print out the object bike2
    }
  
}

