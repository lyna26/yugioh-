package card;

import enums.Limit;

import player.Player;

public interface ICard extends IMonsterCard{

	public Player getOwner();
	
	public void setOwner(Player owner) ;

	public String getName() ;
	
	public int getId() ;
	
	public String getType() ;
	
	public String getDesc() ;
	
	public String getRace() ;
	
	public String getImage() ;
	
	public Limit getLIMIT() ;
}
