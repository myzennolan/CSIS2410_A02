package database;

import adventureApp.Player;

/**
 * Assortment of player specific sql strings.
 * 
 * @author Nolan Harris, Trevor Hodsdon, Dominick Wiley
 *
 */
public class sqlPlayer {

	/**
	 * SQL Query for selecting all fields of all players
	 * 
	 * @return String "select *" SQL query
	 */
	public static String selectAllPlayers() {
		
		return "select * from player";
		
	}

	/**
	 * SQL Query for selecting all fields of a player
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String selectPlayerByID(int id) {
		
		return "select * from player where id = "+id;
		
	}

	/**
	 * SQL Query for selecting all fields of a player
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String selectPlayerByCampaignID(int id) {
		
		return "select distinct t1.* from player t1"
				+ " right join pCharacter t2 on t1.id = t2.playerid"
				+ " right join Experience t3 on t2.experience between t3.minexp and t3.maxexp "
				+ " right join Campaign t4 on t3.level between t4.levellow and t4.levelhigh where t4.id = "+id;
		
	}
	
	/**
	 * SQL Query for adding a record to the player table
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String insertPlayer(String first, String last, String contact) {
		
		return ""
				+ "INSERT INTO player (FirstName,LastName,Contact)"
				+ "VALUES "
				+"('"+first+"', '"+last+"', '"+contact+"')";
		
	}
	
	/**
	 * SQL Query for adding a record to the player table from the Player class
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String insertPlayer(Player player) {
		
		return ""
				+ "INSERT INTO player (FirstName,LastName,Contact)"
				+ "VALUES "
				+"('"+player.getFirstName()+"', '"+player.getLastName()+"', '"+player.getContact()+"')";
		
	}
	
	/**
	 * SQL Query for adding a record to the player table from the Player class
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String updatePlayer(Player player) {
		
		return ""
				+ "UPDATE player "
				+ "Set FirstName = '"+player.getFirstName()+"', LastName = '"+player.getLastName()+"', Contact = '"+player.getContact()+"' "
				+ "WHERE id = "+player.getId();
		
	}

	/**
	 * SQL Query for selecting all fields of a player
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String deletePlayerByID(int id) {
		
		return "delete from player where id = "+id;
		
	}

	/**
	 * SQL string for selecting a list of players whose first or last names begin with a specific character.
	 * @param selectedItem
	 * @return
	 */
	public static String selectPlayerLikeLetter(String selectedItem) {
		// TODO Auto-generated method stub
		return "select * from player where FirstName like '"+selectedItem+"%' or LastName like '"+selectedItem+"%'";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
