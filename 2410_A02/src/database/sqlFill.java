package database;

public class sqlFill {
	
	/**
	 * String for inserting default records into the player table
	 * 
	 * @return Insert statement with 20 records
	 */
	public static String player() {
		return ""
				+ "INSERT INTO player (FirstName,LastName,Contact)"
				+ "VALUES "
				+"('Elvira', 'Chacon-Lopez', 'Canvas Mail'),"
				+"('Carter', 'Cluff', 'Canvas Mail'),"
				+"('Trevor', 'Davis', 'Canvas Mail'),"
				+"('Nolan', 'Harris', 'Canvas Mail'),"
				+"('Trevor', 'Hodsdon', 'Canvas Mail'),"
				+"('William', 'Isom', 'Canvas Mail'),"
				+"('Winston', 'Flores', 'Canvas Mail'),"
				+"('Tanner', 'Krone', 'Canvas Mail'),"
				+"('Anny', 'Lim', 'Canvas Mail'),"
				+"('Elizabeth', 'Lukner', 'Canvas Mail'),"
				+"('Jonathan', 'Mangone', 'Canvas Mail'),"
				+"('Jose', 'Garcia', 'Canvas Mail'),"
				+"('Lucas', 'Montoya', 'Canvas Mail'),"
				+"('Nicholas', 'Murphy', 'Canvas Mail'),"
				+"('Austin', 'Poch', 'Canvas Mail'),"
				+"('Margarethe', 'Posch', 'Canvas Mail'),"
				+"('Isaac', 'Rowlette', 'Canvas Mail'),"
				+"('Aaron', 'Sadler', 'Canvas Mail'),"
				+"('Ramon', 'Sanchez', 'Canvas Mail'),"
				+"('Dominick', 'Wiley', 'Canvas Mail')";
				
  }
  
    //Druid wizard elf knight mage archer warlock Monk paladin ranger rogue bard
	/**
	 * String for inserting default values into the pCharacter table
	 * 
	 * @return Insert String
	 */
    public static String character() {
        return ""
        + "INSERT INTO pCharacter (playerId, name, class, experience, strength, dexterity, constitution, wisdom, charisma, intelligence) "
        + "VALUES "
        + "(1, 'Bob', 'Knight', 500, 10, 10, 15, 1, 50, 6),"
        + "(2, 'Winston', 'Mage', 1200, 3, 3, 500, 3, 6, 0),"
        + "(3, 'Wiley', 'Archer', 3000, 70, 49, 49, 1, 0, 54),"
        + "(4, 'Mangone', 'Knight', 600, 80, 1, 1, 543, 90, 63),"
        + "(5, 'Lukner', 'Fighter', 6400, 45, 643, 643, 568, 31, 75),"
        + "(6, 'Lim', 'Warlock', 2250, 65, 53, 75,  75, 84, 37)";
    }

    /**
     * STring for creating default weapons records in weapons table
     * 
     * @return Insert String
     */
    public static String weapon() {
        return ""
        + "INSERT INTO weapon (name, description, damageDice) "
        + "VALUES "
        + "('Sword', 'A basic sword', '1D4'),"
        + "('Knife', 'A small knife', '1D6'),"
        + "('Staff of magic', 'Basic magic staff', '5D4'),"
        + "('Shield', 'Not really a weapon', '9D7'),"
        + "('Bow', 'A basic bow', '6D6')";
    }

    /**
     * Default experience table records
     * 
     * @return insert string
     */
    public static String experience() {
        return ""
        + "INSERT INTO experience (level, minExp, maxExp) "
        + "VALUES "
        + "(1, 0, 999),"
        + "(2, 1000, 1999),"
        + "(3, 2000, 2999),"
        + "(4, 3000, 3999),"
        + "(5, 4000, 4999),"
        + "(6, 5000, 5999),"
        + "(7, 6000, 6999),"
        + "(8, 7000, 7999),"
        + "(9, 8000, 8999),"
        + "(10, 9000, 9999)";
    }

    /**
     * Default experience table records
     * 
     * @return insert string
     */
    public static String campaign() {
        return ""
        + "INSERT INTO campaign (Name, Setting, Description,LevelLow,LevelHigh,AvailableExp) "
        + "VALUES "
        + "('Bagel Heist', 'New York', 'Why are hobbits attacking a bagelry?',1,4,500)";
    }
}
