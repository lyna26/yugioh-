package card;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;

import enums.Face;
import enums.Limit;
import enums.Position;
import javafx.scene.image.Image;
import player.Player;

public abstract class Card extends javafx.scene.image.ImageView {
	
	private int id;
	private String name;
	private String type;
	private String desc;
	private String race;
	private String image;
	private Player owner;
	private Limit limit = Limit.NO_LIMITED;
	private Face face = Face.UP;

	/**
	 * This constructor is used to generate a card from data formatted as JSon
	 * @param card  its type is JsonNode
	 */
	public Card(JsonNode card, Player owner)
	{
		id =  card.path("id").asInt();
		name = card.path("name").asText();
		type = card.path("type").asText();
		desc = card.path("desc").asText();
		race = card.path("race").asText();
		image = card.path("image").asText();

		this.owner = owner;
	}
	
	/**
	 * This constructor is used to generate a card from data exported from database 
	 * @param cardInfo its type is ResultSet
	 */
	public Card(ResultSet cardInfos, Player owner)
	{
		try {
			id = cardInfos.getInt("id");
			name = cardInfos.getString("name");
			type = cardInfos.getString("type");
			desc = cardInfos.getString("desc");
			race = cardInfos.getString("race");
			image = cardInfos.getString("image");
			
			this.owner = owner;
		} 
		catch (SQLException e) 
		{
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
	public Card(int id, String name, String type, String desc, String race, String image, Player owner) {
		this.id =  id;
		this.name = name;
		this.type = type;
		this.desc = desc;
		this.race = race;
		this.image = image;
		this.owner = owner;
	}

	public Player getOwner() {
		return owner;
	}

	public String getName() {
		return name;
	}
	
	public int getIdCard() {
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
	
	/*public String getImage() {
		return image;
	}
	*/
	public Limit getLIMIT() {
		return limit;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public void setCardImage(Image image){
        setImage(image);
	}

	public void setImage(){
		String path = "https://images.ygoprodeck.com/images/cards/64591429.jpg";
		System.out.println(path);
	    setCardImage(new Image(path));
	}
}
