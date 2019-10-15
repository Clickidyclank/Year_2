package sample;

public class Racecar extends Car{

    private double topSpeed;

    public Racecar(String make, String model, int reg_num, int millage, int year, double topSpeed) {
        super(make, model, reg_num, millage, year);
    this.topSpeed = topSpeed;

    }

    @Override
    public String toString() {
        return "Racecar:\n" +
                super.toString() +
                "topSpeed: " + topSpeed

                ;
    }
}
