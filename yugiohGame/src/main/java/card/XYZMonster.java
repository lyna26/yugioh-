package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class XYZMonster extends ExtraMonster{

	/**
	 * @param card
	 * @param owner
	 */
	public XYZMonster(JsonNode card, Player owner) {
		super(card, owner);
	}

	/**
	 * @param cardInfos
	 * @param owner
	 */
	public XYZMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}
}
