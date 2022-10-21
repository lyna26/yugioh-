package card;

import java.util.ArrayList;
import java.util.List;

public class MainDeck extends Deck{
	
	public MainDeck()
	{
		super(40, 60);
	}
	
	public MainDeck (List<Card> deck)
	{
		super(deck, 40, 60);
	}
}
