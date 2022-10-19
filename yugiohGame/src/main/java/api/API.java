package api;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;

import javax.swing.text.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class API {
	
	/**
	 * This function will collect all cards data from 'db.ygoprodeck.com/api/v7/cardinfo.php?'
	 *@return the result of API research that is a JSonNode type, null otherwise
	 * 
	 */
	public static JsonNode getCardData()
	{
		try 
		{
	         URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?");
	
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         
	         conn.setRequestMethod("GET");
	         
	         conn.connect();
	
	         //Check if connect is made
	         int responseCode = conn.getResponseCode();
	
	         // 200 OK
	         if (responseCode != 200) 
	         {
	             throw new RuntimeException("HttpResponseCode: " + responseCode);
	         } 
	         else 
	         {
	        	 ObjectMapper mapper = new ObjectMapper();
	        	
	        	 JsonNode cardData = mapper.readTree(url.openStream());
	        	
	        	 return cardData;
	        	 //mapper.writeValue(Paths.get("cardsTest.json").toFile(), cardData.get("data").toString());  
	        	//Use method to convert XML string content to XML Document object
	        	   // Document doc = convertStringToXMLDocument( url.openStream().toString() );
	         }
	     } 
		catch (Exception e) 
		{
	         e.printStackTrace();
	         
	         return null;
		}
	}
}
