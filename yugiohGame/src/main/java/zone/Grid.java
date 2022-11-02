package zone;

import java.util.List;

import card.ICard;

public class Grid 
{
	private List<ICard> cards; 
	
	private int nbCards ;
	
	public List<ICard> getCards() {
		return cards;
	}

	public void setCards(List<ICard> cards) {
		this.cards = cards;
	}

	public int getNbCards() {
		return nbCards;
	}

	public void setNbCards(int nbCards) {
		this.nbCards = nbCards;
	}

	public Grid(List<ICard> cards)
	{
		this.cards = cards ;
		
		this.nbCards = cards.size();
	}
}
