package yugioh;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InvalidNameException;

import org.junit.Test;

import card.Card;
import card.MonsterCard;

import engines.DatabaseEngine;
import engines.ExporterCardDataEngine;


public class ExporterCardDataEngineTest {
	
	@Test
	public void parseTextTest() throws SQLException
	{
		
		List<Card> kuribandit = TestTools.generateMonstes();
		
		try {
			for(Card c : kuribandit)
			{
				try {
					ExporterCardDataEngine.addTagsTo(c);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}