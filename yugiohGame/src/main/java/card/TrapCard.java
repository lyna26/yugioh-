package card;

import java.sql.ResultSet;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

/**
 * @author Lyna
 *
 */
public class TrapCard extends Card{

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param desc
	 * @param race
	 * @param image
	 * @param owner
	 */
	public TrapCard(int id, String name, String type, String desc, String race, String image, Player owner) {
		super(id, name, type, desc, race, image, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param card
	 * @param owner
	 */
	public TrapCard(JsonNode card, Player owner) {
		super(card, owner);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cardInfos
	 * @param owner
	 */
	public TrapCard(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		// TODO Auto-generated constructor stub
	}
}
