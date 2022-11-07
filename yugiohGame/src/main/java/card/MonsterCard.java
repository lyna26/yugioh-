package card;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;

import enums.Position;
import player.Player;


public abstract class MonsterCard extends Card {
	
	private int atk;
	private int def;
	private int level;
	private String attribute;
	private Position mode;
	
	/**
	 * This constructor is used to generate a monster card from data formated as Json
	 * @param card its type is JsonNode
	 * @param owner player 
	 */
	public MonsterCard(JsonNode card, Player owner) {
		super(card, owner);
		
		this.atk =  card.path("atk").asInt();
		this.def = card.path("def").asInt();
		this.level = card.path("level").asInt();
		this.attribute = card.path("attribute").asText();
	}
	
	/**
	 * This constructor is used to generate a monster card from data exported from database 
	 * @param cardInfos its type is ResultSet
	 */
	public MonsterCard(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		
		try {
			this.atk = cardInfos.getInt("atk");
			this.def = cardInfos.getInt("def");
			this.level = cardInfos.getInt("level");
			this.attribute = cardInfos.getString("attribute");	
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public MonsterCard(int id, String name, String type, String desc, String race, String image, String imageSmall,
			Player owner) {
		super(id, name, type, desc, race, image, imageSmall, owner);
		
	}

	public int getAtk() {
		return atk;
	}
	
	public int getDef() {
		return def;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
	public Position getMode() {
		return mode;
	}

	public void setMode(Position mode) {
		this.mode = mode;
	}

	public int calculateDamage(int monster, int opponent)
	{
		return monster - opponent;
		
	}
}
