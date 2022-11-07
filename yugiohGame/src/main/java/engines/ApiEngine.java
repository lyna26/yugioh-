package engines;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiEngine {

	/**
	 * This function will collect all cards data from 'db.ygoprodeck.com/api/v7/cardinfo.php?'
	 *@return the result of API research that is a JSonNode type, null otherwise
	 *
	 */
	public static JsonNode getCardData()
	{
		try
		{
			URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?name=astral kuriboh");

			//URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?name=Dark Magician");
			
			//URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?");

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

	        	//BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));


	        	/*String strCurrentLine;

	        	while ((strCurrentLine = br.readLine()) != null)
	        	{
	        		System.out.println(strCurrentLine);
	        	}*/

	        	
	        	//ObjectMapper mapperT = new ObjectMapper();
	        	
	        	//mapperT.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        	
	            //CardList cardList = mapperT.readValue(br, CardList.class);
	           
	          // cardList.getData()[0].getDesc().codePoints().forEach(System.out::println);
	        	  
	        	//JsonNode cardData = mapper.readTree(br);

	        	ObjectMapper mapper = new ObjectMapper();
	        	
	        	JsonNode cardData = mapper.readTree(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
	        	
	        	return cardData;
	         }
	     }
		catch (Exception e)
		{
	         e.printStackTrace();

	         return null;
		}
	}
}
