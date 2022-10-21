package engines;

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
	
	private static Map<Integer, String> namePositionMap = new HashMap<Integer, String>();

	
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
                    + "encrypt=false";
	                       		
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
	
	/**
	 * This function will do an insert query
	 * @param connexion the connexion to database
	 * @param card data formatted as json 
	 * @exception SQLException
	 */
	public static void insertCard(Connection connexion,JsonNode card ) throws SQLException
	{
		//TODO find a way to find the type of the field and user the position fieldname mapper to automate and never modify
		
		String reqParam = "insert into card VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = connexion.prepareStatement(reqParam);
		
		pstm.setInt (1, card.path("id").asInt());
		pstm.setString(2, card.path("name").asText());
		pstm.setString(3, card.path("type").asText());
		pstm.setString(4, card.path("desc").asText());
		pstm.setInt(5, card.path("atk").asInt());
		pstm.setInt(6, card.path("def").asInt());
		pstm.setInt(7, card.path("level").asInt());
		pstm.setString(8, card.path("race").asText());			
		pstm.setString(9, card.path("attribute").asText());
		pstm.setString(10, card.get("card_images").toString());
		pstm.setInt(11, card.path("linkval").asInt());
		
		if (card.path("linkmarkers").isMissingNode() != true)
		{
			pstm.setString(12, card.get("linkmarkers").toString());
		}	
		else
		{
			pstm.setString(12, "");
		}
		pstm.setInt(13, card.path("scale").asInt());
		//pstm.setBoolean(14, isStaple);
		
		int count = pstm.executeUpdate();	
	}
}