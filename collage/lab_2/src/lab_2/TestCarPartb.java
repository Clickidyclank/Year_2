package lab_2;

import java.util.Scanner;

public class TestCarPartb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 0;

		System.out.println("how many cars would you like to enter");
		int Array_lenght = sc.nextInt();
		Car Car_array[] = new Car[Array_lenght];

		for (i = 0; i < Array_lenght; i++) {
			System.out.println("please enter the name of the car");
			String carName = sc.next();
			System.out.println("please enter the age of your car");
			int carAge = sc.nextInt();
			System.out.println("please enter the price of your car");
			float carPrice = sc.nextFloat();

			Car car1 = new Car(carAge, carPrice, carName);
			Car_array[i] = car1;

		}
		for (Car x : Car_array) {
			x.print();
		}
		sc.close();
	}

}
