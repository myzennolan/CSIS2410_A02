package database;

public class sqlFill {
	
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
    public static String character() {
        return ""
        + "INSERT INTO pCharacter (playerId, name, class, experience, dexterity, constitution, wisdom, charisma, intelligence) "
        + "VALUES "
        + "(1, 'Bob', 'Knight', 0, 10, 15, 1, 50, 6),"
        + "(2, 'Winston', 'Mage', 5, 3, 500, 3, 6, 0),"
        + "(3, 'Wiley', 'Archer', 3, 70, 49, 1, 0, 54),"
        + "(4, 'Mangone', 'Knight', 6, 80, 1, 543, 90, 63),"
        + "(5, 'Lukner', 'Fighter', 64, 45, 643, 568, 31, 75),"
        + "(6, 'Lim', 'warlock', 41, 65, 53, 75, 84, 37)";
    }

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

    public static String experience() {
        return ""
        + "INSERT INTO experience (level, minExp, maxExp) "
        + "VALUES "
        + "(1, 6, 10),"
        + "(5, 20, 500),"
        + "(7, 32, 68),"
        + "(8, 43, 87)";
    }
}
