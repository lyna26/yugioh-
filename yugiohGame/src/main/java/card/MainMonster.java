package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class MainMonster extends MonsterCard{

	/**
	 * @param card
	 * @param owner
	 */
	public MainMonster(JsonNode card, Player owner) {
		super(card, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cardInfos
	 * @param owner
	 */
	public MainMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param desc
	 * @param race
	 * @param image
	 * @param imageSmall
	 * @param owner
	 */
	public MainMonster(int id, String name, String type, String desc, String race, String image, String imageSmall,
			Player owner) {
		super(id, name, type, desc, race, image, imageSmall, owner);
		// TODO Auto-generated constructor stub
	}

	
}
