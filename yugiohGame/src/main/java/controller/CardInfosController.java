package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import card.Card;
import card.MainMonster;
import card.MonsterCard;
import engines.DatabaseEngine;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class CardInfosController {
	
	@FXML 
	ImageView bigCardImageView;
	
	@FXML
	TextArea cardDescriptionTextArea;
	
	/**
	 * This function will change the image of the cardInfos interface
	 * @throws SQLException 
	 */
	public void changeCard() throws SQLException
	{
		//TODO when the card.onclick event is availabe, remove the instance of the card
		//Card c = new Card(64591429, "Astral Kuriboh", "You can reveal 1 \\\"Number\\\" Xyz Monster in your Extra Deck; Special Summon this card from your hand. If you do, this card's Level becomes the revealed monster's Rank, also while it is face-up in the Monster Zone, you cannot Special Summon monsters from the Extra Deck, except \\\"Number\\\" Xyz Monsters. You can only use this effect of \\\"Astral Kuriboh\\\" once per turn. A \\\"Number\\\" Xyz Monster that was Summoned using this card on the field as material gains this effect.\\r\\n\\u25cf Cannot be destroyed by battle or your opponent's card effectse", "Dragon LIGHT", "https://images.ygoprodeck.com/images/cards/89631139.jpg" );
		ResultSet res = DatabaseEngine.selectCards(DatabaseEngine.connect(), "Astral Kuriboh");
		
		while(res.next())
		{
			System.out.println(res.getString("name"))  ;
			
			Card c  = new  MainMonster(res, null);
		
			
			System.out.println(c.getDesc());
			
			System.out.println(c.getImage());
			
			
			bigCardImageView.setImage(new Image("https://images.ygoprodeck.com/images/cards/64591429.jpg"));
			cardDescriptionTextArea.setText(c.getDesc());
		}
		
	
	}
}
