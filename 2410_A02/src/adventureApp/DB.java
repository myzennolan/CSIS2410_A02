package adventureApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.sqlCampaign;
import database.sqlCharacter;
import database.sqlPlayer;

/**
 * This is the local Database of the Adventure Database Application.
 * It holds the players, characters, campaigns, and weapons of the application.
 * @author Nolan Harris, Trevor Hodson, and Dominick Wiley
 *
 */
public class DB {

	/**
	 * runs executePlayerQueries and returns ArrayList<Players>
	 * 
	 * @param id
	 * @return players ArrayList<Players>
	 * @throws SQLException
	 */
	public static ArrayList<Player> getPlayers(int id) throws SQLException {
		ArrayList<Player> players;
		String sql = (id == 0 ? sqlPlayer.selectAllPlayers():sqlPlayer.selectPlayerByID(id));
		
		players = executePlayerQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return players;
		
	}

	/**
	 * Runs executeStatement deletePlayerByID sql parameter.
	 * @param id "player id"
	 * @throws SQLException
	 */
	public static void deletePlayer(int id) throws SQLException {
		ArrayList<Player> players;
		String sql = sqlPlayer.deletePlayerByID(id);
		
		executeStatement(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		//return players;
		
	}

	/**
	 * Updates or inserts record to players table. Inserts if id is 0, updates if not.
	 * @param player
	 * @throws SQLException
	 */
	public static void commitPlayerToDB(Player player) throws SQLException {
		//ArrayList<Player> players;
		String sql = (player.getId() == 0 ? sqlPlayer.insertPlayer(player) :  sqlPlayer.updatePlayer(player));
		
		executeStatement(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		//return players;
		
	}
	
	/**
	 * Returns ArrayList of characters, all if id = 0 or matching character if id != 0.
	 * @param id
	 * @return characters
	 * @throws SQLException
	 */
	public static ArrayList<AdvCharacter> getCharacters(int id) throws SQLException {

		ArrayList<AdvCharacter> characters = new ArrayList<>();
		String sql = (id == 0 ? sqlCharacter.selectAllCharacters():sqlCharacter.selectCharacterByID(id));
		
		characters = executeCharacterQueries(sql);
		
		
		
		//characters = executeQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return characters;
	}	
	
	/**
	 * Returns ArrayList of characters, all if id = 0 or matching character if id != 0.
	 * @param id
	 * @return characters
	 * @throws SQLException
	 */
	public static ArrayList<AdvCharacter> getPlayerCharacters(int id) throws SQLException {

		ArrayList<AdvCharacter> characters = new ArrayList<>();
		String sql = (id == 0 ? sqlCharacter.selectAllCharacters():sqlCharacter.selectCharacterByPlayerID(id));
		
		characters = executeCharacterQueries(sql);
		
		
		
		//characters = executeQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return characters;
	}
	
	/**
	 * Returns ArrayList of campaigns, all if id = 0 or matching campaign if id != 0.
	 * @param id
	 * @return campaigns
	 */
	public static  ArrayList<Campaign> getCampaigns(int id) {
		ArrayList<Campaign> campaigns = new ArrayList<>();
		String sql = (id == 0 ? sqlCampaign.selectAllCampaigns():sqlCampaign.selectCampaignByID(id));
		
		campaigns = executeCampaignQueries(sql);
		
		
		
		//characters = executeQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return campaigns;
	}
	
	/**
	 * Player queries return an ArrayList of Players
	 * 
	 * @param query
	 * @return players
	 */
	private static ArrayList<Player> executePlayerQueries(String query) {
		ArrayList<Player> players = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;");
	        Statement statement = connection.createStatement();) {
	    	
	     // for (String query : queries) {
	        ResultSet results = statement.executeQuery(query);
	      
	        ResultSetMetaData metaData = results.getMetaData();
	        while (results.next()) {

	        	 players.add(
	        			 new Player(
	        					 (int) results.getObject(1),
	        					 (String) results.getObject(2),
	        					 (String) results.getObject(3),
	        					 (String) results.getObject(4)));
	        }

	        System.out.println("Got "+players.size()+" Players");
	        
	        return players;
	   //   }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	  }
	
	/**
	 * Characters queries return an ArrayList of AdvCharacters
	 * @param query
	 * @return characters
	 */
	private static ArrayList<AdvCharacter> executeCharacterQueries(String query) {
		ArrayList<AdvCharacter> characters = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;");
	        Statement statement = connection.createStatement();) {
	    	
	     // for (String query : queries) {
	        ResultSet results = statement.executeQuery(query);
	      
	        ResultSetMetaData metaData = results.getMetaData();
	        while (results.next()) {

	          	 characters.add(new AdvCharacter(
	          					 (int) results.getObject(1),
	          					 (int) results.getObject(2),
	          					 (String) results.getObject(3),
	          					 (String) results.getObject(4),
	          					 (int) results.getObject(5),
	          					 (int) results.getObject(6),
	          					 (int) results.getObject(7),
	          					 (int) results.getObject(8),
	          					 (int) results.getObject(9),
	          					 (int) results.getObject(10),
	          					 (int) results.getObject(11),
	          					 (int) results.getObject(12)
	          					 ));
	          }

	        System.out.println("Got "+characters.size()+" Characters");
	        
	        return characters;
	   //   }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	  }
	
	/**
	 * Campaign queries return an array list of campaigns.
	 * @param query
	 * @return
	 */
	private static ArrayList<Campaign> executeCampaignQueries(String query){
		ArrayList<Campaign> campaign = new ArrayList<>();
	    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;");
	        Statement statement = connection.createStatement();) {
	    	
	     // for (String query : queries) {
	        ResultSet results = statement.executeQuery(query);
	      
	        ResultSetMetaData metaData = results.getMetaData();
	        while (results.next()) {

	        	campaign.add(new Campaign(
	          					 (int) results.getObject(1),
	          					 (String) results.getObject(2),
	          					 (String) results.getObject(3),
	          					 (String) results.getObject(4),
	          					 (int) results.getObject(5),
	          					 (int) results.getObject(6),
	          					 (int) results.getObject(7)
	          					 ));
	          }

	        System.out.println("Got "+campaign.size()+" Campaigns");
	        
	        return campaign;
	   //   }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return null;
	  }

	/**
	 * Executes statements for all tables.
	 * 
	 * @param statements
	 */
	private static void executeStatement(String... statements) {
	    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;create=true");
	        Statement statement = connection.createStatement();) {

	      for (String sqlStatement : statements) {
	        statement.execute(sqlStatement);
	      }

	    } catch (SQLException e) {
	        // Ignore 'table already exists' errors
	        // if (e.getErrorCode() == 30000) {
	        //     return;
	        // }

	        e.printStackTrace();
	    }
	  }
	
	/**
	 * for testing
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			for(Campaign p:getCampaigns(0)) {
				System.out.println(p.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Player> filterPlayers(String selectedItem) {
		ArrayList<Player> players;
		String sql = (selectedItem == "Players" ? sqlPlayer.selectAllPlayers():sqlPlayer.selectPlayerLikeLetter(selectedItem));
		
		players = executePlayerQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return players;
	}

}
