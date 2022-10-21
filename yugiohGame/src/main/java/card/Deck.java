package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Deck {
	
	private List<Card> deck ;
	
	private int  minCard;
	
	private int maxCard;
	
	public Deck(int minCard, int maxCard)
	{
		deck = new ArrayList<Card>();
	}
	
	public Deck (List<Card> deck, int minCard, int maxCard)
	{
		this.deck = deck;
	}
	
	public boolean isValid()
	{
		//size of the deck 
		int size = deck.size() ;
		
		//count each card occurences
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

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public int getMinCard() {
		return minCard;
	}

	public int getMaxCard() {
		return maxCard;
	}

	public void setMinCard(int minCard) {
		this.minCard = minCard;
	}

	public void setMaxCard(int maxCard) {
		this.maxCard = maxCard;
	}
}
