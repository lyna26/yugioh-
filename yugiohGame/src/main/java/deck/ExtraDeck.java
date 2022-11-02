package deck;

import java.util.List;

import card.ICard;

public class ExtraDeck extends Deck{
	

	public ExtraDeck()
	{
		super(0, 15);
	}
	
	public ExtraDeck (List<ICard> deck)
	{
		super(deck, 0, 15);
	}
}
