package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DeckBuilderController implements Initializable{
	
	@FXML
	BorderPane cardBuilderPane ;

	Node leftPane;
	
	Node rightPane;
	
	
	/**
	 * This function will initialize the cardBuilderPane
	 */
	
	//TODO find a better way to generate the cardBuilderPane threw the fxml file
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		FXMLLoader loader;
		
		try {
			
			loader = new FXMLLoader(new File("src/main/java/interfaces/cardInfosInterface.fxml").toURI().toURL());
			
			leftPane = loader.load();	
			
			loader = new FXMLLoader(new File("src/main/java/interfaces/SearchCardInterface.fxml").toURI().toURL());
			
			rightPane = loader.load();	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		cardBuilderPane.setLeft(leftPane);		
		cardBuilderPane.setRight(rightPane);
	}
}
