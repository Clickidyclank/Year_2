package application;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Hashtable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;

public class prizeController {

	Main mn;
	
	prizeController(Main m){
		// creates a call back method so I can access the mains methods
		mn = m;
		}
	
//	AlertBox AB;
	
//	public void onClick(ListView lv ) {
//		// print out selected item.
//		 String result = outputButtonClicked(lv);
//		
//		Dialog prizeAlert = new Alert(Alert.AlertType.WARNING);
//		prizeAlert.setTitle("shitty wizard");
//	
//		
//		
//		
//		prizeAlert.setContentText("Here is your prize: " + mn.getHashTable().get(result));
//		prizeAlert.show();
//		}
	
//	public void onClick(ListView lv ) {
//		// print out selected item.
//		AB.display("Prize claiming", outputButtonClicked(lv));
//		
//		Dialog prizeAlert = new Alert(Alert.AlertType.NONE);
//		prizeAlert.setTitle("shitty wizard");
//		prizeAlert.setContentText("Here is your prize: " + mn.getHashTable().get());
//		
//		}
		
//	public void testReading() throws Exception {
//		FileReader file = new FileReader("prizes.txt");
//		
//		BufferedReader reader = new BufferedReader(file);
//		
//		String text = "";
//		String line = reader.readLine();
//		while (line != null) {
//			text = text + line;
//			line = reader.readLine();
//		}
//		
//		reader.close();
//	}
	
//	public String outputButtonClicked(ListView listView) {
//		String message = "";
//		
//		ObservableList<String> prizes;
//		
//		prizes = listView.getSelectionModel().getSelectedItems();
//		
//		for(String m: prizes) {
//			message += m + "\n";
//		}
//		
//		return message;	
//	}
	
	public String outputButtonClicked(ListView listView) {
		String message = "";
		
		ObservableList prizes = listView.getSelectionModel().getSelectedItems();  
		String change = prizes.toString();

		return change;	
	}
	
	
//	public void populateTheList(ListView listview, Hashtable hash) {
//		
//		mn.getListView().getItems().clear();
//		
//		int prizeNum = 1;
//		String prizeKey = "prize" + prizeNum;
//		
//		try {
//			FileReader file = new FileReader("prizes.txt");
//			
//			BufferedReader reader = new BufferedReader(file);
//			
//			String line = reader.readLine();
//			
//			while (line != null) {
//
//				mn.getHashTable().put(prizeKey, line);
//				//System.out.println(prizeKey);
//				
//				prizeNum ++;
//				prizeKey  = "prize" + (prizeNum);
//				
//				line = reader.readLine();
//			}
//			
//			if (mn.getStarNumber() == 2 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//			}
//			else if( mn.getStarNumber() >= 3 && mn.getStarNumber() <= 5 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//			}
//			else if (mn.getStarNumber() >= 6 && mn.getStarNumber() < 8 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//			}
//			else if (mn.getStarNumber() >= 8 && mn.getStarNumber() < 10 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize7"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize8"));
//			}
//			else if (mn.getStarNumber() >= 10) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize7"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize8"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize9"));
//			}
//			else mn.getListView().getItems().add("No more prizes currently available.");
//			
//	        mn.getListView().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//	        
//			reader.close();
//			
//			} catch (Exception e1) {
//
//				e1.printStackTrace();
//			}
//		
//		HBox hbox2 = new HBox();
//		hbox2.setAlignment(Pos.CENTER);	
//			
//			hbox2.setPadding(new Insets (20 ,20 ,20 ,20));
//			hbox2.getChildren().addAll(mn.getListView(), mn.getTestButton());
//			
//			mn.getTab3().setContent(hbox2);
//		}
	
public void populateTheList(ListView listview, Hashtable hash) {
		//Clears the list
		mn.getListView().getItems().clear();
		
//		int prizeNum = 1;
//		String prizeKey = "prize" + prizeNum;
		
		try {
			//Creates teh file reader and points to the alt.txt
			FileReader file = new FileReader("alt.txt");
			//Creates a buffer reader that reads in from the file that was pointed to.
			BufferedReader reader = new BufferedReader(file);
			// the one that reads the lines
			String line = reader.readLine();
			
			while (line != null) {

				//Creates the string array that will hold the parts of the hash table.
				String[] hashBits = line.split(";");
				
//				System.out.println(hashBits[0]);
//				System.out.println(hashBits[1]);
//				System.out.println(hashBits[2]);
				
				//Adds the correct prizes based off of the star value to the hash table.
				if(mn.getStarNumber() >= Integer.parseInt(hashBits[0] )) {
				mn.getHashTable().put(hashBits[2], hashBits[1]);
				//System.out.println(prizeKey);
				}
				
				line = reader.readLine();
			}
			
			// This sets the strings onto the observable list
			for(String counters : mn.getHashTable().keySet()) {
				mn.getListView().getItems().add(counters);
			}
			
			
//			if (mn.getStarNumber() == 2 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//			}
//			else if( mn.getStarNumber() >= 3 && mn.getStarNumber() <= 5 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//			}
//			else if (mn.getStarNumber() >= 6 && mn.getStarNumber() < 8 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//			}
//			else if (mn.getStarNumber() >= 8 && mn.getStarNumber() < 10 ) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize7"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize8"));
//			}
//			else if (mn.getStarNumber() >= 10) {
//				mn.getListView().getItems().add(mn.getHashTable().get("prize1"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize2"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize3"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize4"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize5"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize6"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize7"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize8"));
//				mn.getListView().getItems().add(mn.getHashTable().get("prize9"));
//			}
//			else mn.getListView().getItems().add("No more prizes currently available.");
			
	        mn.getListView().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	        
			reader.close();
			
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		
		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.CENTER);	
			
			hbox2.setPadding(new Insets (20 ,20 ,20 ,20));
			hbox2.getChildren().addAll(mn.getListView(), mn.getTestButton());
			
			mn.getTab3().setContent(hbox2);
		}
	
	
}
