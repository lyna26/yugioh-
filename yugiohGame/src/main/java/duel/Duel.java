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
	
	public boolean isFinished()
	{
		//Réduire les Life Points de votre adversaire à 0
		
		//Votre adversaire est incapable de piocher une carte alors qu'il doit le faire
	
			
		//Effet de carte
		
		return true;
	}
}
