package yugioh;

import java.util.List;

import org.junit.Test;

import card.Card;
import card.Deck;
import card.MonsterCard;

public class DeckTest {
	
	@Test
	public void isValidSizeTest()
	{
		List<Card> monsters = TestTools.generateMonstes();
		
		System.out.println("cards size is" + monsters.size());
	
		
		Deck deckLessThanMin = TestTools.generateDeck(9, monsters);
		
		Deck deckMoreThanMax = TestTools.generateDeck(61, monsters);
		
		Deck deckValid = TestTools.generateDeck(42, monsters);
		
		
		assert(deckLessThanMin.isValid() == false);
		
		assert(deckMoreThanMax.isValid() == false);
		
		assert(deckValid.isValid());
	}
	
	@Test
	public void isValidLIMITTest()
	{
		List<Card> monsters = TestTools.generateMonstes();
		
		System.out.println("cards size is" + monsters.size());
	
		
		Deck deckValid = TestTools.generateDeck(42, monsters);
		
		Deck deckInvalid = TestTools.generateDeck(42, monsters);
		
		deckInvalid.getDeck().add(monsters.get(0)); //two copies
		deckInvalid.getDeck().add(monsters.get(0)); // three copies
		deckInvalid.getDeck().add(monsters.get(0)); // four copies
		
		deckValid.getDeck().add(monsters.get(0)); //two copies
		deckValid.getDeck().add(monsters.get(0)); // three copies
		
		assert(deckValid.isValid() == true);
	
		assert(deckInvalid.isValid() == false);
	}
	
	
}
