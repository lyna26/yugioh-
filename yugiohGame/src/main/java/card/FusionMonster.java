package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class FusionMonster extends ExtraMonster
{

	/**
	 * @param card
	 * @param owner
	 */
	public FusionMonster(JsonNode card, Player owner) {
		super(card, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cardInfos
	 * @param owner
	 */
	public FusionMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}

}
