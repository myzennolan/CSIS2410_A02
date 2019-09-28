package adventureApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.sqlPlayer;

public class DB {

	public static ArrayList<Player> getPlayers(int id) throws SQLException {
		ArrayList<Player> players;
		String sql = (id == 0 ? sqlPlayer.selectAllPlayers():sqlPlayer.selectPlayerByID(id));
		
		players = executeQueries(sql);
		//ResultSetMetaData metaData = results.getMetaData();
		return players;
		
	}
	
	public AdvCharacter[] getCharacters() {
		return null;
	}
	
	public Campaign[] getCampaigns() {
		return null;
	}
	
	private static ArrayList<Player> executeQueries(String query) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			for(Player p:getPlayers(0)) {
				System.out.println(p.getFirstName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
