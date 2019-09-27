package database;

/**
 * Repository of table maintenance/creation scripts
 * 
 * @author Nolan Harris, Trevor Hodsdon, Dominick Wiley
 *
 */
public class sqlCreate {
	/*
	public static String adventureDatabase(){
		return "CREATE DATABASE AdventureDB";	
	}
    */

	/**
	 * truncates the referenced table
	 * 
	 * @param table
	 * @return table truncation script
	 */
    public static String deleteAll(String table) {
        return "truncate table " + table;
    }
    
    /**
     * drops the referenced table
     * 
     * @param table
     * @return drop table script
     */
    public static String deleteTable(String table) {
        return "drop table " + table;
    }
	
    /**
     * creates the player table
     * 
     * @return player table creation script
     */
	public static String tablePlayer() {
		return "CREATE TABLE Player (" + 
		"id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), \r\n" + 
		"FirstName varchar(255), \r\n" + 
		"LastName varchar(255), \r\n" + 
		"Contact varchar(255), \r\n" + 
		"PRIMARY KEY (id) \r\n" + 
		")";
	}
	
    /**
     * creates the pCharacter table
     * 
     * @return pCharacter table creation script
     */
	public static String tableCharacter() {
		return " " + 
		"CREATE TABLE pCharacter ( " + 
		"id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), \r\n" + 
		"playerID int, \r\n" + 
		"Name varchar(255), \r\n" + 
		"Class varchar(255), \r\n" + 
		"Experience int, \r\n" + 
		"Strength int, \r\n" + 
		"Dexterity int, \r\n" + 
		"Constitution int, \r\n" + 
		"Wisdom int, \r\n" + 
		"Charisma int, \r\n" + 
		"Intelligence int, \r\n" + 
		"PRIMARY KEY (id) " + 
		") ";
	}
	
    /**
     * creates the weapon table
     * 
     * @return weapon table creation script
     */
	public static String tableWeapon() {
		return " " + 
		"CREATE TABLE Weapon ( " + 
		"id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), \r\n" + 
		"Name varchar(255), \r\n" + 
		"Description VARCHAR(4000), \r\n" + 
		"DamageDice varchar(16), \r\n" + 
		"PRIMARY KEY (id) " + 
		")";
	};

    /**
     * creates the experience table
     * 
     * @return experience table creation script
     */
	public static String tableExperience() {
		return " " + 
		"CREATE TABLE Experience ( " + 
		"level int, \r\n" + 
		"minExp int, \r\n" + 
		"maxExp int " + 
		") " ;
	}

    /**
     * creates the campaign table
     * 
     * @return campaign table creation script
     */
	public static String tableCampaign() {
		return " " + 
		"CREATE TABLE Campaign ( " + 
		"id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), \r\n" + 
		"Name varchar(1024), \r\n" + 
		"Setting varchar(1024), \r\n" + 
		"Description VARCHAR(4000), \r\n" + 
		"levelLow int, \r\n" + 
		"levelHigh int, \r\n" + 
		"availableExp int, \r\n" + 
		"PRIMARY KEY (id) " + 
		") ";
	}
	
    /**
     * creates the lookup table for joining characters and weapons
     * 
     * @return CharacterWeapons table creation script
     */
	public static String tableCharcterWeapons() {
		return " " + 
		"CREATE TABLE CharacterWeapons ( " + 
		"characterID int, \r\n" + 
		"weaponID int " + 
		") ";
	}
	
    /**
     * creates the lookup table for joining characters and campaign
     * 
     * @return CampaignCharacters table creation script
     */
	public static String tableCampaignCharacters() { 
		return " " + 
		"CREATE TABLE CampaignCharacters ( " + 
		"campaignID int, \r\n" + 
		"characterID int " + 
		") ";
	}
}
