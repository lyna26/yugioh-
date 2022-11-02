package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class SyncMonster extends MonsterCard{

	/**
	 * @param card
	 * @param owner
	 */
	public SyncMonster(JsonNode card, Player owner) {
		super(card, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cardInfos
	 * @param owner
	 */
	public SyncMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}

}
