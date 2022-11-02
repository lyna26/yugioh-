package deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import card.ICard;

public abstract class Deck {
	
	private String name;
	
	private List<ICard> deck ;	
	
	protected int  minCard;
	
	protected int maxCard;
	
	public Deck(int minCard, int maxCard)
	{
		this.minCard = minCard;
		
		this.maxCard = maxCard;
		
		deck = new ArrayList<ICard>();
	}
	
	public Deck (List<ICard> deck, int minCard, int maxCard)
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

	public List<ICard> getDeck() {
		return deck;
	}

	public void setDeck(List<ICard> deck) {
		this.deck = deck;
	}

	public int getMinCard() {
		return minCard;
	}

	public int getMaxCard() {
		return maxCard;
	}
}
