package deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import card.Card;

public abstract class Deck {
	
	private String name;
	
	private List<Card> deck ;	
	
	private  int  minCard;
	
	private int maxCard;
	
	public Deck(int minCard, int maxCard)
	{
		this.minCard = minCard;
		
		this.maxCard = maxCard;
		
		deck = new ArrayList<Card>(maxCard);
	}
	
	public Deck (List<Card> deck, int minCard, int maxCard)
	{
		this.deck = deck;
		this.minCard = minCard;
		this.maxCard = maxCard;
	}
	
	public boolean isValid()
	{
		//size of the deck 
		int size = deck.size() ;
	
		//count each card occurrences
		 Map<String,Long> occurrenceMap = deck.stream().collect(Collectors.groupingBy(card -> card.getName(),Collectors.counting()));

		 //check
		if (size <= minCard || size >= maxCard)
		{
			return false;
		}
		else if (deck.stream().filter(card -> card.getLIMIT().getNbCopies()< occurrenceMap.get(card.getName())).count() > 0)
		{
			return false ;
		}
		else
		{
			return true ;
		}
	}

	public void addCard(Card card)
	{
		deck.add(card);
	}
	
	public void removeCard(Card card)
	{
		deck.remove(card);
	}
	
	public void clearDeck()
	{
		deck.clear();	
	}

	
	public List<Card> getDeck() {
		return deck;
	}

	
	public int getMinCard() {
		return minCard;
	}

	public int getMaxCard() {
		return maxCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
