package engines;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InvalidNameException;

import com.fasterxml.jackson.databind.JsonNode;

import card.Card;

public class ExporterCardDataEngine {
	
	
	public static void analyseResolution(String resolution)
	{
	
		System.out.println("RESOLUTION ::" + resolution + "/n");
	}
	
	public static void analyseActivation(String activation)
	{
		System.out.println("ACTIVATION ::" + activation + "/n");
	}
	
	public static void analyseCondition(String condition)
	{
		System.out.println("CONDITION ::" + condition + "/n");
	}
	
	public static void analyseSentence(String sentence) throws InvalidNameException
	{
		String[] sentences ;
		
		sentences = sentence.split(";");
		
		try
		{
			try
			{
				analyseCondition(sentences[0].split(":")[0].toString());
				
				analyseActivation(sentences[0].split(":")[1].toString());
			}
			
			catch (ArrayIndexOutOfBoundsException e) 
			{
				System.out.println("no ; on the sensence !!");
			}
		}
		
		catch (ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("no ; on the sensence !!");
		}
		
	}
	
	public static void addTagsTo(Card card) throws InvalidNameException
	{		
		String[] sentences ;
		
		System.out.println(card.getDesc());
		
		try
		{
			
			//sentences = card.getDesc().split(".");
			sentences = card.getDesc().split("\\.");
			
			System.out.println(sentences.length);
			
		
			if (sentences.length == 0)
			{
				System.out.println("One sentence texte /n");
				
				analyseSentence(card.getDesc());
			}
			else
			{
				System.out.println("many sentences !!");
				
				for(String sentence : sentences)
				{
					System.out.println("ANALYSE" + sentence + "/n");
					analyseSentence(sentence);
					
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
			 throw new InvalidNameException("error");
		}
	}
	
	/**
	 * This function will export API data to database
	 * @throws SQLException 
	 */
	public static void exportApiData() throws SQLException
	{
		
		JsonNode cards = ApiEngine.getCardData().get("data");
		
		Connection connexion = DatabaseEngine.connect();
		
		int size = cards.get("data").size();
		
		for (int i = 0; i < size; i++)
		{
			System.out.println((i + 1) +"/" + size + cards.get(i).get("name").toString());
			
			DatabaseEngine.insertCard(connexion, cards.get(i));
		}
	}

}
