package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.Border;
import board.BorderStroke;
import board.square;
import card.Card;
import card.MainMonster;
import card.MonsterCard;
import engines.DatabaseEngine;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import utilities.position;




//TODO finish the filter part and searching cards
public class SearchCardController {
	
	@FXML 
	TextArea cardNameInputText;
	
	@FXML 
	GridPane cardGrid;
	
	public void searchCard()
	{
		System.out.println("hello");
		
		String cardName = cardNameInputText.getText() ;
	
		System.out.println(cardName);
		
		if (cardName != "")
		{
			try
			{
				Connection connex = DatabaseEngine.connect();
			
				ResultSet res = DatabaseEngine.selectCards(connex, cardName);
				
				int count = 0;
				
				while(res.next())
				{
			        System.out.println("name: " + res.getString("name"));

			        Card c = new MainMonster(res, null);
			        
			        c.setImage();
					
			        cardGrid.add(c, count, 0);
			        count++;
			        
			     }	
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
