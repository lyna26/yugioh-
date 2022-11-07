package engines;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;



public class DatabaseEngine {
	
	public static Map<Integer, String> namePositionMap = new HashMap<Integer, String>();

	
	/**
	 * This function will help to automate the export data by mapping position and field name
	 */
	public static void initiateMap()
	{
		namePositionMap.put(1, "id");
		namePositionMap.put(2, "name");
		namePositionMap.put(3, "type");
		namePositionMap.put(4, "desc");
		namePositionMap.put(5, "atk");
		namePositionMap.put(6, "def");
		namePositionMap.put(7, "level");
		namePositionMap.put(8, "race");
		namePositionMap.put(9, "attribute");
		namePositionMap.put(10, "card_images");
		namePositionMap.put(11, "linkval");
		namePositionMap.put(12, "linkmarkers");
		namePositionMap.put(13, "scale");
	}
	
	
	public static void applyFilterToSelect(String query)
	{
	
	}
	
	public static void isFilteredData()
	{
	
	}
	

	/**
	 * This function is a simple select query with the name of the monster
	 * @param connexion 
	 * @param name card name to search
	 * @return res the result of the query
	 */
	public static ResultSet selectCards(Connection connexion, String name) throws SQLException
	{
		String reqParam = "SELECT * FROM card WHERE name LIKE "+"'%"+name+"%'";
		
		Statement stmt = connexion.createStatement();
		
		ResultSet res = stmt.executeQuery(reqParam);
		
		return res;
	}
	
	/**
	 * This function will connect to the database
	 * @return return the connexion
	 */
	public static Connection connect()
	{
		//TODO secure all this : confidential infos...
		String url = 
	                "jdbc:sqlserver://MSI:1433;"
                    + "database=yugioh;"
            		+ "integratedSecurity=false;"
                    + "user=lola;"
                    + "password=test123;"
                    + "encrypt=false;"
                    + "sendStringParametersAsUnicode=true;"
					+ "CharacterSet=UTF-8";
		
	                       		
		try 
		{
			Connection connexion = DriverManager.getConnection(url);
			System.out.println("success connexion");
			return connexion;
		} 
		catch (SQLException e)
		{
			System.out.println("error here : ");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void insertCards(Connection connexion) throws SQLException
	{
		String req = "SELECT * FROM OPENROWSET (BULK 'D:\\yug.json', SINGLE_CLOB) as import";
		
		
		Statement stmt = connexion.createStatement();
		
		ResultSet res = stmt.executeQuery(req);
		//PreparedStatement pstm = connexion.prepareStatement(req);
		
		
		//int res = pstm.executeUpdate();
		
	}
	/**
	 * This function will do an insert query
	 * @param connexion the connection to database
	 * @param card data formatted as Json 
	 * @exception SQLException
	 * @throws UnsupportedEncodingException 
	 */
	public static void insertCard(Connection connexion,JsonNode card ) throws SQLException, UnsupportedEncodingException
	{
			
		String reqParam = "insert into card VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = connexion.prepareStatement(reqParam);
		
		
		JsonNode cardImages = card.path("card_images");
        
		
	    for (JsonNode node : cardImages) 
	    {
	        int id= node.path("id").asInt();
	        
	        String img = node.path("image_url").asText();
	        
	        String SmallImg = node.path("image_url_small").asText();
	  
			pstm.setInt (1, id);
			pstm.setString(2, card.path("name").asText());
			pstm.setString(3, card.path("type").asText());
			
			Charset utf8 = Charset.forName("UTF-8");
	        
			Charset def = Charset.defaultCharset();

	        byte[] bytes = card.path("desc").asText().getBytes("UTF-8");
	        
	        String desc = new String(bytes , def.name());
	        
			pstm.setNString(4,  desc);
			pstm.setInt(5, card.path("atk").asInt());
			pstm.setInt(6, card.path("def").asInt());
			pstm.setInt(7, card.path("level").asInt());
			pstm.setString(8, card.path("race").asText());			
			pstm.setString(9, card.path("attribute").asText());
			pstm.setString(10, img);
			pstm.setInt(11, card.path("linkval").asInt());			
			pstm.setString(12, card.path("linkmarkers").asText());
			pstm.setInt(13, card.path("scale").asInt());
			pstm.setString(14, SmallImg);
		
			int count = pstm.executeUpdate();	
		}
	}
}