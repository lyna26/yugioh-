package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class LinkMonster extends ExtraMonster{
	
	public LinkMonster(JsonNode card, Player owner) {
		super(card, owner);
	}

	public LinkMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}
}
