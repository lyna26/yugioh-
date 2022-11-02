package yugioh;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import card.Card;
import card.MonsterCard;
import enums.Position;
import player.Player;


 public class monsterCardTest {
	 
	@Test
	public void attacktest()
	{

		List<Card> monsters = TestTools.generateMonstes();
		
		List<Player> players = TestTools.generatePlayer(2);
		
	
		MonsterCard cardOwner = (MonsterCard) monsters.get(0);
		
		MonsterCard cardOpponent = (MonsterCard) monsters.get(1);
		
		cardOwner.setOwner(players.get(0));
		cardOpponent.setOwner(players.get(1));
	
		
		cardOwner.setMode(Position.ATK);
		cardOpponent.setMode(Position.ATK);
		
		cardOwner.attack(cardOpponent);
		
		int damage = Math.abs(cardOwner.getAtk() - cardOpponent.getAtk());
		
		System.out.println("owner monster name , atk & def :" + cardOwner.getName() + "   "  + cardOwner.getAtk() + "/" + cardOwner.getDef());
		
		System.out.println("Opponent monster name , atk & def :" + cardOpponent.getName() + "    " + cardOpponent.getAtk() + cardOpponent.getDef());
		
		
		System.out.println("damage :" + damage);
		

		System.out.println("LP owner :" + players.get(0).getLp());
		
		System.out.println("LP opponent :" + players.get(1).getLp());
		
		if (cardOpponent.getAtk() > cardOwner.getAtk())
		{
			assert( players.get(0).getLp() == (8000 - damage));
		}
		else
		{
			assert( players.get(0).getLp() == (8000- damage));
		}
	}
}
