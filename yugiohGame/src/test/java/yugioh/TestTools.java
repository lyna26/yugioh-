package yugioh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import card.Card;
import card.ICard;
import card.MonsterCard;
import deck.Deck;
import engines.DatabaseEngine;
import player.Player;

import org.junit.Test;


public class TestTools {
	
	public static List<Card> generateMonstes() {
		
		try {
			
			List<Card> monsters = new ArrayList<Card>();
			
			Connection connex = DatabaseEngine.connect();
			
			ResultSet res = DatabaseEngine.selectCards(connex, "KURIBOH");
			
			while(res.next()){
		        System.out.println("name: " + res.getString("name"));
		        
		        monsters.add(new Card(res, null));
		     }
			
			return monsters;
		
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	public static List<Player> generatePlayer(int nbPlayer)
	{
		List<Player> players = new ArrayList<Player>();
		 
		for (int i = 1 ; i <= 5; i++)
		{
			players.add(new Player(8000));
		}
		
		return players ;
	}
	
	public static Deck generateDeck(int nbCards, List<Card> cards)
	{
		Deck deck ;
		
		if (nbCards == cards.size())
		{
			System.out.println("create deck from an existing List");
			deck = new Deck(cards);
			
		}
		else
		{
			System.out.println("create deck from a part of a list");
			deck = new Deck();
			
			 cards.stream().limit(nbCards).forEachOrdered(deck.getDeck()::add);
		}
			 
		
		System.out.println("new deck of" + deck.getDeck().size() + "cards");
		
		return deck ;
	}
}
