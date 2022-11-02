package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public abstract class SpellCard extends Card{

	public SpellCard(int id, String name, String type, String desc, String race, String image, Player owner) {
		super(id, name, type, desc, race, image, owner);
	}

	public SpellCard(JsonNode card, Player owner) {
		super(card, owner);
	}

	public SpellCard(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
	}
}
