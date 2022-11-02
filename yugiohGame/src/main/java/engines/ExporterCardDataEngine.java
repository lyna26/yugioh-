package engines;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InvalidNameException;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

import card.Card;
import card.ICard;

public class ExporterCardDataEngine {
	
	//private String[] conjunctives= {"then", "and", "and if you do", "also", "also, after"};
	
	
	public static void analyseResolution(String resolution)
	{
		System.out.println("RESOLUTION ::" + resolution + "/n");
	}
	
	public static void analyseActivation(String activation)
	{
		String activ = activation ;
		
		if (activation.contains(":"))
		{
			analyseCondition(activation.split(":")[0]);
			
			activ = activation.split(":")[1];
		}
		System.out.println("ACTIVATION ::" + activ + "/n");
	}
	
	public static void analyseCondition(String condition)
	{
		System.out.println("CONDITION ::" + condition + "/n");
	}
	
	public static void analyseSentence(String sentence) throws InvalidNameException
	{
		
		if (sentence.contains(";"))
		{
			analyseResolution(sentence.split(";")[1]);
			
			analyseActivation(sentence.split(";")[0]);
		}
		else if (sentence.contains(":"))
		{
			analyseActivation(sentence);
		}
		else
		{
			System.out.println("No chain monster : " + sentence);
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
		
		int size = cards.size();
		
		System.out.println(size);
		
		for (int i = 0; i < size; i++)
		{
			System.out.println((i + 1) +"/" + size + cards.get(i).get("desc").asText());
			
			DatabaseEngine.insertCard(connexion, cards.get(i));
		}
	}
	
	public static void addTagsTo(Card c) throws InvalidNameException
	{		
		System.out.println(c.getDesc());
		
		String[] sentences = c.getDesc().split("\\.");
		
		for(String sentence : sentences)
		{
			System.out.println("ANALYSE" + sentence + "/n");
			
			analyseSentence(sentence);
			
		}
	}
	
	public static void main(String args[])
	{
		try {
			exportApiData();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
