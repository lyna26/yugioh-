package card;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;

import player.Player;

public class MonsterCard extends Card{
	
	private int atk;
	private int def;
	private int level;
	private String attribute;
	private Position mode;
	
	/**
	 * This constructor is used to generate a monster card from data formated as Json
	 * @param card it type is JsonNode
	 */
	public MonsterCard(JsonNode card) {
		super(card);
		this.atk =  card.path("atk").asInt();
		this.def = card.path("def").asInt();
		this.level = card.path("level").asInt();
		this.attribute = card.path("attribute").asText();
	}
	
	/**
	 * This constructor is used to generate a monster card from data exported from database 
	 * @param cardInfos its type is ResultSet
	 */
	public MonsterCard(ResultSet cardInfos) {
		super(cardInfos);
		try {
			this.atk = cardInfos.getInt("atk");
			this.def = cardInfos.getInt("def");
			this.level = cardInfos.getInt("level");
			this.attribute = cardInfos.getString("attribute");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	
	
	/*public void attackDirectly()
	{
		player = this.getOwner().
		p.looseLp(this.getAtk());
	}*/
	
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
	
	/**
	 * This function is for the battle phase, it will calculate damage and reduce LP from the target
	 * @param monster it is the target monster
	 */
	public void attack(MonsterCard monster){
		
		if (monster == null)
		{
			//TODO think about finding the opponent to direct attack 
		}
		else
		{
			int damage = 0;
			
			//damage calculation
			if (monster.getMode() == Position.DEF)
			{
				damage = calculateDamage(this.getAtk(), monster.getDef());
			}
			else
			{
				damage = calculateDamage(this.getAtk(),monster.getAtk());
			}
			
			
			//reduce lp
			if (damage == 0)
			{
				//TODO case opponent must both die bacause same LP
			}
			else if (damage < 0)
			{
				this.getOwner().looseLp(damage);
			}
			else
			{
				monster.getOwner().looseLp(damage);
			}
			
		}
	}
}
