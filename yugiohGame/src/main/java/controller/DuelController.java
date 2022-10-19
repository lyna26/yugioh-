package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class DuelController implements Initializable {
	
	@FXML
	BorderPane duelBorderPane;

	Node leftPane;
	
	/**
	 * This function will initialize the duelBorderPane
	 */
	
	//TODO find a better way to generate the cardBuilderPane threw the fxml file
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			System.out.println("duel init...");
	
			FXMLLoader loader = new FXMLLoader(new File("src/main/java/interfaces/cardInfosInterface.fxml").toURI().toURL());
			
			leftPane = loader.load();
			
			duelBorderPane.setLeft(leftPane);	
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

			
	}

}
