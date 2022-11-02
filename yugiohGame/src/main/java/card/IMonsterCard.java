package card;

import enums.Position;

public interface IMonsterCard {
	
	public int getAtk() ;
	
	public int getDef() ;
	
	public int getLevel() ;
	
	public String getAttribute() ;
	
	public Position getMode() ;
	
	
	public void setAtk(int atk) ;

	public void setDef(int def) ;

	public void setLevel(int level) ;
	
	public void setAttribute(String attribute) ;
	

	public void setMode(Position mode) ;

}
