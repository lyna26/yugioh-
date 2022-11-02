package zone;

import java.util.ArrayList;
import java.util.List;

import card.MonsterCard;
import card.SpellCard;

public class ZoneMonster extends Zone{

	ZoneMonster() {
		super(5);
		
		for(int i = 0; i < 5; i++)
		{
			this.getGrids()[i] = new Grid(new List<ICard>());
		}
	}
}
