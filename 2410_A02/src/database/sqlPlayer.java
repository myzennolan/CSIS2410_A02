package database;

public class sqlPlayer {

	/**
	 * 
	 * @return
	 */
	public static String selectAllPlayers() {
		
		return "select * from player";
		
	}
	
	public static String selectPlayerByID(int id) {
		
		return "select * from player where id = "+id;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
