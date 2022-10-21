package card;

import java.util.List;

public class ExtraDeck extends Deck{
	

	public ExtraDeck()
	{
		super(0, 15);
	}
	
	public ExtraDeck (List<Card> deck)
	{
		super(deck, 0, 15);
	}

}
