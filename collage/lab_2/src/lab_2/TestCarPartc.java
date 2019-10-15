	package lab_2;
import java.util.*;
public class TestCarPartc {
	int i = 0;
	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			
		
			ArrayList<String> carList = new ArrayList<String>();
			
			int option = 0;
			
			
			while (option  !=1) {
				
				System.out.println("please select an option" + "\n"+"1: Add a car"+"\n"+"2: Remove a car"+"\n"+"3: List"+"\n"+"4: Exit");
				int nav = sc.nextInt();
				if (nav ==1 ) {
					
					//position 0 for model position 1 for year and position 2 is for price for the first car
					
					// for the second car position 3 is for model ,4 for year and 5 for price and so on
					System.out.println("please enter the model of the car");
					 carList.add(sc.next());
					System.out.println("please enter the year of the car");
					carList.add(sc.next());
					System.out.println("please enter the price of the car");
					carList.add(sc.next());
					
					
					
					
				}
				
				else if (nav==2) {
					System.out.println("please enter the position of the model you want to remove");
					int removeModel = sc.nextInt();
					
					carList.remove(removeModel);
					carList.remove(removeModel);
					carList.remove(removeModel);
					
					
				}
				else if (nav ==3) {
					System.out.println(carList);
					
					
				}
				else if (nav==4){
					option =1;
				}
				
		
			
			
		}
		sc.close();}
		
		}

// we use array lists are they are flexible in size in comparison to arrays which have a fixed size. 
		

