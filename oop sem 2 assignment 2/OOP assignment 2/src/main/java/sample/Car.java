package sample;

import javafx.collections.FXCollections;

import java.io.Serializable;

public class Car implements Serializable,Comparable<Car> {

    private String make;
    private String model;
    private int reg_num;
    private int millage;
    private int year;

    public Car(String make, String model, int reg_num, int millage, int year) {
        this.make = make;
        this.model = model;
        this.reg_num = reg_num;
        this.millage = millage;
        this.year = year;

    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReg_num() {
        return reg_num;
    }

    public void setReg_num(int reg_num) {
        this.reg_num = reg_num;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {

        return ("Make: " + this.getMake())+
          "\nModel: "+ this.getModel() +
        " \nReg_num: "+ this.getReg_num() +
        "\nMillage: "+ this.getMillage()+
        " \nYear: " + this.getYear()+ "\n";

    }


    public void Natural(){


    }

    @Override
    public int compareTo(Car o) {
        if (this.model.compareTo(o.getModel())!=0){
            return this.make.compareTo(o.getMake());
        }
        else {
            return this.model.compareTo(o.getModel());
        }

    }

    public int yearCompare(Car o){

        return Integer.compare(this.year,o.getYear());
    }

    public int millageCompare(Car o){

        return Integer.compare(this.millage,o.getMillage());
    }
}
