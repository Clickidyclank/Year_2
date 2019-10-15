package application;

import javafx.stage.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.geometry.*;

public class AlertBox {

	Main mn;
	
	AlertBox(Main m){
		mn = m;
		}
	
	
	public void display(String title, String string) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		window.setMinHeight(250);
		
		Label label = new Label();
		
		String test = mn.getHashTable().get(string);
		
		System.out.println(test);
		
		label.setText("You have selected the prize : " + test );
		Button closeButton = new Button("Claim prize.");
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
	
	
}
