package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import card.MainMonster;
import engines.DatabaseEngine;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class DeckBuilderController implements Initializable{

	//SEARCH CARD ENGINE=========================
	@FXML TextArea cardNameInputText;
	
	@FXML GridPane cardResultList;
	
	//CARD INFOS INTERFACE=======================
	@FXML AnchorPane cardInfos;
	
	@FXML  CardInfosController cardInfosController ;
	
	  
	public void searchCard() throws IOException
	{
		String cardName = cardNameInputText.getText() ;
			
		if (cardName != "")
		{
			try
			{
				Connection connex = DatabaseEngine.connect();
			
				ResultSet res = DatabaseEngine.selectCards(connex, cardName);
				
				int countCol = 0;
				
				int countRow = 0;
		
				while(res.next())
				{

					cardResultController controller = new cardResultController(res);
					
					controller.getStage().getScene().getRoot().setOnMouseEntered(new EventHandler<MouseEvent>() {
		                
					@Override
	                public void handle(MouseEvent event) {
	                	
	                	System.out.println("mouseEvent");
	                	
	                	System.out.println(event.getTarget());	 
	                	  	
	                	Parent anchor = (Parent) event.getTarget() ;
	                	
	                	/*try {
							cardInfosController.setBigCardImageView(((ResultSet) anchor.getScene().getUserData()).getString("image"));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}*/
	                	
	                	try {
							cardInfosController.setCardDescriptionTextArea((((ResultSet) anchor.getScene().getWindow().getUserData()).getString("desc")));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                
	                }
	            });
			    
			        if (countCol == 2)
			        {
			        	countCol = 0;
			        
			        	countRow++;
			        }
			        
			        FXMLLoader menuLoader = new FXMLLoader();
			        
			        cardResultList.add(controller.getStage().getScene().getRoot(), countCol, countRow);
			        
			        countCol++;
			     }	
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		    
		        System.out.println( cardInfos);
		        System.out.println(cardInfosController);
	}
}
