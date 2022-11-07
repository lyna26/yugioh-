package engines;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InvalidNameException;

import com.fasterxml.jackson.databind.JsonNode;

import card.Card;

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
	
	
	public static void analyseSimpleText(String text) throws UnsupportedEncodingException
	{
        
		if (text.contains("\u25cf") == true)
		{
			System.out.println("textContainsDot");
		}
		else
		{
			System.out.println("No ';' or ':' in the sentence :  " + text);
		}
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
			try {
				analyseSimpleText(sentence);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * This function will export API data to database
	 * @throws SQLException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void exportApiData() throws SQLException, UnsupportedEncodingException
	{
		
		JsonNode cards = ApiEngine.getCardData().get("data");
		
		Connection connexion = DatabaseEngine.connect();
		
		int size = cards.size();
		
	
		for (int i = 0; i < size; i++)
		{	
			DatabaseEngine.insertCard(connexion, cards.get(i));
		}
	}
	
	public static void addTagsTo(Card c) throws InvalidNameException, UnsupportedEncodingException
	{		
		
		String[] sentences = c.getDesc().split("\\.");
		
		for(String sentence : sentences)
		{
			System.out.println("ANALYSE" + sentence + "/n");
			
			analyseSentence(sentence);		
		}
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException
	{
		try 
		{
			exportApiData();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
