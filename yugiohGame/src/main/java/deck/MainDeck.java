package deck;

import java.util.List;

import card.ICard;

public class MainDeck extends Deck{
	
	public MainDeck()
	{
		super(40,60);
	}
	
	public MainDeck (List<ICard> deck)
	{
		super(deck, 40, 60);
	}
}
