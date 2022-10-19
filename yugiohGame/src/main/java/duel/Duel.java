package duel;

public class Duel {
	private static final Duel singDuel;
	
	static
	{
		singDuel = new Duel();
	}
	
	private Duel(){}
	
	public static Duel getInstance()
	{
		return singDuel;
	}
}
