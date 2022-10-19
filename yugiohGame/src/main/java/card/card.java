package card;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;

import player.player;

public class card {
	private int id;
	private String name;
	private String type;
	private String desc;
	private String race;
	private String image;
	private player owner;

	/**
	 * This constructor is used to generate a card from data formatted as JSon
	 * @param card  its type is JsonNode
	 */
	public card(JsonNode card)
	{
		this.id =  card.path("id").asInt();
		this.name = card.path("name").asText();
		this.desc = card.path("desc").asText();
		this.race = card.path("race").asText();
		this.image = card.path("image").asText();
	}
	
	/**
	 * This constructor is used to generate a card from data exported from database 
	 * @param cardInfo its type is ResultSet
	 */
	public card(ResultSet cardInfos)
	{
		try {
			this.id = cardInfos.getInt("id");
			this.name = cardInfos.getString("name");
			this.desc = cardInfos.getString("desc");
			this.race = cardInfos.getString("race");
			this.image = cardInfos.getString("image");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This constructor is used to generate a card manually
	 * @param id  card id
	 * @param name card name
	 * @param desc card description
	 * @param race card race 
	 * @param image card images list formatted as csv (;)
	 */
	public card(int id, String name, String desc, String race, String image) {
		this.id =  id;
		this.name = name;
		this.desc = desc;
		this.race = race;
		this.image = image;
	}

	public player getOwner() {
		return owner;
	}


	public void setOwner(player owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getRace() {
		return race;
	}
	
	public String getImage() {
		return image;
	}
}
