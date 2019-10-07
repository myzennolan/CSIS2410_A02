package database;

import adventureApp.AdvCharacter;
import adventureApp.Player;

public class sqlCharacter {

	/**
	 * 
	 * @return
	 */
	public static String selectAllCharacters() {
		
		return "select t1.*,CASE WHEN t2.level is null then 0 else t2.level end as level from pcharacter as t1 "
				+ "left join experience as t2 on t1.experience between t2.minExp and t2.maxExp";
		
	}
	
	public static String selectCharacterByID(int id) {
		
		return "select t1.*,CASE WHEN t2.level is null then 0 else t2.level end as level from pcharacter as t1 "
				+ "left join experience as t2 on t1.experience between t2.minExp and t2.maxExp"
				+ " where id = "+id;
		
	}
	
	public static String selectCharacterByPlayerID(int id) {
		
		return "select t1.*,CASE WHEN t2.level is null then 0 else t2.level end as level from pcharacter as t1 "
				+ "left join experience as t2 on t1.experience between t2.minExp and t2.maxExp "
				+ "where playerid = "+id;
		
	}
	
	/**
	 * SQL Query for adding a record to the player table from the Player class
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String insertCharacter(AdvCharacter advCharacter) {
		
        return ""
        + "INSERT INTO pCharacter (playerId, name, class, experience, strength, dexterity, constitution, wisdom, charisma, intelligence) "
        + "VALUES "
        + "(" + advCharacter.getPlayerID() +","
        + " '"+advCharacter.getName()+"',"
        + " '"+advCharacter.getCharClass()+"',"
        + advCharacter.getExperience()+", "
        + advCharacter.getStrength()+", "
        + advCharacter.getDexterity()+", "
        + advCharacter.getConstitution()+", "
        + advCharacter.getWisdom()+", "
        + advCharacter.getCharisma()+", "
        + advCharacter.getIntelligence()
        +")";
		
	}
	
	/**
	 * SQL Query for adding a record to the player table from the Player class
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String updateCharacter(AdvCharacter advCharacter) {
		
		return ""
				+ "UPDATE pCharacter "
				+ "Set Name = '"+advCharacter.getName()+"',"
				        + "Class = '"+advCharacter.getCharClass()+"',"
				        + "Experience = "+advCharacter.getExperience()+", "
				        + "Strength = "+advCharacter.getStrength()+", "
				        + "Dexterity = "+advCharacter.getDexterity()+", "
				        + "Constitution = "+advCharacter.getConstitution()+", "
				        + "Wisdom = "+advCharacter.getWisdom()+", "
				        + "Charisma = "+advCharacter.getCharisma()+", "
				        + "Intelligence = "+advCharacter.getIntelligence()
				+ " WHERE id = "+advCharacter.getId();
		
	}
	
	/**
	 * SQL Query for selecting all fields of a player
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String deleteCharacterByID(int id) {
		
		return "delete from pCharacter where id = "+id;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
