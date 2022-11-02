package zone;

public abstract class Zone {
	
	private Grid[] grids ;
	
	public Zone(int nbGrids)
	{
		grids = new Grid[nbGrids];
	}
	
	public Grid[] getGrids() {
		return grids;
	}	
}
