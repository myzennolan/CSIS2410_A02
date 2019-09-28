package database;

public class sqlCharacter {

	/**
	 * 
	 * @return
	 */
	public static String selectAllCharacters() {
		
		return "select * from pcharacter";
		
	}
	
	public static String selectCharacterByID(int id) {
		
		return "select * from pcharacter where id = "+id;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
