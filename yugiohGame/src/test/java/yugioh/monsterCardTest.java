package yugioh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.card;
import card.monsterCard;
import database.databaseConnector;
import duel.MODE;
import player.player;


 public class monsterCardTest {

	List<monsterCard> monsters = new ArrayList<monsterCard>();
	
	@Test
	public void generateMonstes() {
		
		try {
			
			Connection connex = databaseConnector.connect();
			
			ResultSet res = databaseConnector.selectCards(connex, "Blue-eyes");
			
			while(res.next()){
		        System.out.println(",name: " + res.getString("name"));
		        
		        monsterCard c= new monsterCard(res);
		        
		        monsters.add(c);
		     }
			
			assert(monsters.size() > 0);
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	
	@Test
	public void attacktest()
	{
		generateMonstes();
		
		
		player owner = new player(8000);
		
		player opponent = new player(8000);
	
		monsterCard cardOwner = monsters.get(0);
		monsterCard cardOpponent = monsters.get(1);
		
		cardOwner.setOwner(owner);
		cardOpponent.setOwner(owner);
	
		
		cardOwner.setMode(MODE.ATK);
		cardOpponent.setMode(MODE.ATK);
		
		cardOwner.attack(cardOpponent);
		
		int damage = Math.abs(cardOwner.getAtk() - cardOpponent.getAtk());
		
		System.out.println("owner monster name , atk & def :" + cardOwner.getName() + "   "  + cardOwner.getAtk() + "/" + cardOwner.getDef());
		
		System.out.println("Opponent monster name , atk & def :" + cardOpponent.getName() + "    " + cardOpponent.getAtk() + cardOpponent.getDef());
		
		
		System.out.println("damage :" + damage);
		

		System.out.println("LP owner :" + owner.getLp());
		
		System.out.println("LP opponent :" + opponent.getLp());
		
		if (cardOpponent.getAtk() > cardOwner.getAtk())
		{
			assert(owner.getLp() == (8000 - damage));
		}
		else
		{
			assert(opponent.getLp() == (8000- damage));
		}
	}
}
