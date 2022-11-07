package controller;

import java.net.URL;
import java.util.ResourceBundle;

import card.Card;
import card.MainMonster;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class DeckController  implements Initializable{
	
	private String name;
	

	public DeckController(String name)
	{
		this.name = name;
	}
	
	@FXML
    GridPane DeckGridPan;

	@FXML 
	TextFlow deckInfos ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	MainMonster c = new MainMonster(64591429, "Astral Kuriboh", "monter", "You can reveal 1 \\\"Number\\\" Xyz Monster in your Extra Deck; Special Summon this card from your hand. If you do, this card's Level becomes the revealed monster's Rank, also while it is face-up in the Monster Zone, you cannot Special Summon monsters from the Extra Deck, except \\\"Number\\\" Xyz Monsters. You can only use this effect of \\\"Astral Kuriboh\\\" once per turn. A \\\"Number\\\" Xyz Monster that was Summoned using this card on the field as material gains this effect.\\r\\n\\u25cf Cannot be destroyed by battle or your opponent's card effectse", "Dragon LIGHT", "https://images.ygoprodeck.com/images/cards/89631139.jpg", "https://images.ygoprodeck.com/images/cards_small/89631139.jpg", null);
    	c.setImage(new Image(c.getImageSmall()));
    	DeckGridPan.add(c,0,0);
    	deckInfos.getChildren().addAll(new Text(name + "[" + 0 + "]" + "spell" +  "[" + 0 + "]" + "trap" + "[" + 0 + "]" + "monster" + "[" + 0 + "]"));
    }		
}
