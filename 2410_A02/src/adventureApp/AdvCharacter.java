package adventureApp;
/**
 * This is the AdvCharacter class for the Adventure Database App. These are
 * the characters that each player uses within the application.
 * @author Nolan Harris
 *
 */
public class AdvCharacter {
	private int id;
	private int playerID;
	private String Name;
	private String CharClass;
	private int Experience;
	private int Strength;
	private int Dexterity;
	private int Constitution;
	private int Wisdom;
	private int Charisma;
	private int Intelligence;
	private int Level;
	
	// getters and setters
	/**
	 * Returns the name of the Character
	 * 
	 * @return Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Returns the "Class" or "Occupation" of the Character
	 * 
	 * @return CharClass
	 */
	public String getCharClass() {
		return CharClass;
	}

	/**
	 * Returns the accumulated experience point of the Character
	 * 
	 * @return Experience
	 */
	public int getExperience() {
		return Experience;
	}

	/**
	 * Returns the Strength the Character
	 * 
	 * @return Strength
	 */
	public int getStrength() {
		return Strength;
	}

	/**
	 * Returns the Dexterity the Character
	 * 
	 * @return Dexterity
	 */
	public int getDexterity() {
		return Dexterity;
	}

	/**
	 * Returns the Constitution the Character
	 * 
	 * @return Constitution
	 */
	public int getConstitution() {
		return Constitution;
	}

	/**
	 * Returns the Wisdom the Character
	 * 
	 * @return Wisdom
	 */
	public int getWisdom() {
		return Wisdom;
	}

	/**
	 * Returns the Charisma the Character
	 * 
	 * @return Charisma
	 */
	public int getCharisma() {
		return Charisma;
	}

	/**
	 * Returns the Intelligence the Character
	 * 
	 * @return Intelligence
	 */
	public int getIntelligence() {
		return Intelligence;
	}

	/**
	 * Returns the id the Character
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the level of the character. 
	 * Dynamically populated on database read.
	 * 
	 * @return Level
	 */
	public int getLevel() {
		return Level;
	}

	/**
	 * Returns the id number of the player the character belongs to.
	 * 
	 * @return playerID
	 */
	public int getPlayerID() {
		return playerID;
	}
	// end of getters and setters

	@Override
	public String toString()
	{
		return "Name: " + Name 
				+ "\nClass: " +CharClass 
				+ "\nExperience: " + Experience
				+ "\nLevel: " + Level
				+ "\n\nStrength: " + Strength 
				+ "\nDexterity: " + Dexterity 
				+ "\nConstitution: "	+ Constitution 
				+ "\nWisdom: " + Wisdom 
				+ "\nCharisma: " + Charisma 
				+ "\nIntelligence: "	+ Intelligence;
	}
	
	/**
	 * Instantiated a new AdvCharacter object.
	 * 
	 * @param id
	 * @param playerID
	 * @param name
	 * @param charClass
	 * @param experience
	 * @param strength
	 * @param dexterity
	 * @param constitution
	 * @param wisdom
	 * @param charisma
	 * @param intelligence
	 * @param level
	 */
	public AdvCharacter(int id, int playerID, String name, String charClass, int experience, int strength,
			int dexterity, int constitution, int wisdom, int charisma, int intelligence, int level) {
		super();
		this.id = id;
		this.playerID = playerID;
		Name = name;
		CharClass = charClass;
		Experience = experience;
		Strength = strength;
		Dexterity = dexterity;
		Constitution = constitution;
		Wisdom = wisdom;
		Charisma = charisma;
		Intelligence = intelligence;
		Level = level;
	}
	
	// unused method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
