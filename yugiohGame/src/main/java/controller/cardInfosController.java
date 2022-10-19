package controller;

import card.card;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class cardInfosController {
	
	@FXML 
	ImageView bigCardImageView;
	
	@FXML
	Text cardDescriptionTextArea;
	
	/**
	 * This function will change the image of the cardInfos interface
	 */
	public void changeCard()
	{
		//TODO when the card.onclick event is availabe, remove the instance of the card
		card c = new card(89631139, "Blue-Eyes White Dragon", "This legendary dragon is a powerful engine of destruction. Virtually invincible, very few have faced this awesome creature and lived to tell the tale", "Dragon LIGHT", "https://images.ygoprodeck.com/images/cards/89631139.jpg" );
		
		bigCardImageView.setImage(new Image(c.getImage()));
		
		System.out.println(c.getDesc());
		
		cardDescriptionTextArea.setText(c.getDesc());
	}
}
