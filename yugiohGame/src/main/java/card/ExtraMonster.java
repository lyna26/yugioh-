package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public abstract class ExtraMonster extends MonsterCard {

	public ExtraMonster(JsonNode card, Player owner) {
		super(card, owner);
	}

	public ExtraMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
	}
}
