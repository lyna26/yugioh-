package card;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class PendulumMonster extends ExtraMonster{

	private int scale; 
	
	public PendulumMonster(JsonNode card, Player owner) {
		super(card, owner);
		
		this.setScale(card.path("scale").asInt()); 
		
	}

	public PendulumMonster(ResultSet cardInfos, Player owner) {
		super(cardInfos, owner);
		
		try {
			this.setScale(cardInfos.getInt("scale"));
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}
}
