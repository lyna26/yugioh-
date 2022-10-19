package player;
import java.sql.SQLException;
import java.util.List;

import card.DECK;

public class player {
	
	int lp;
	List<DECK> decks;
	int indexCurrentDeck;
	String name;
	
	/**
	 * This constructor will enerate a simple player with known LP
	 */
	public player(int lp)
	{
		this.lp = lp;
	}
	
	public int getLp() {
		return lp;
	}
	public void setLp(int lp) {
		this.lp = lp;
	}
	public List<DECK> getDecks() {
		return decks;
	}
	public void setDecks(List<DECK> decks) {
		this.decks = decks;
	}
	public int getIndexCurrentDeck() {
		return indexCurrentDeck;
	}
	public void setIndexCurrentDeck(int indexCurrentDeck) {
		this.indexCurrentDeck = indexCurrentDeck;
	}
	
	public void looseLp(int toloose)
	{
		this.lp -= Math.abs(toloose);
	}
	
	public void gainLp(int togain)
	{
		this.lp += Math.abs(togain);
	}
}
