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
	
	// getters and setters
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCharClass() {
		return CharClass;
	}

	public void setClass(String charClass) {
		this.CharClass = charClass;
	}

	public int getExperience() {
		return Experience;
	}

	public void setExperience(int experience) {
		Experience = experience;
	}

	public int getStrength() {
		return Strength;
	}

	public void setStrength(int strength) {
		Strength = strength;
	}

	public int getDexterity() {
		return Dexterity;
	}

	public void setDexterity(int dexterity) {
		Dexterity = dexterity;
	}

	public int getConstitution() {
		return Constitution;
	}

	public void setConstitution(int constitution) {
		Constitution = constitution;
	}

	public int getWisdom() {
		return Wisdom;
	}

	public void setWisdom(int wisdom) {
		Wisdom = wisdom;
	}

	public int getCharisma() {
		return Charisma;
	}

	public void setCharisma(int charisma) {
		Charisma = charisma;
	}

	public int getIntelligence() {
		return Intelligence;
	}

	public void setIntelligence(int intelligence) {
		Intelligence = intelligence;
	}

	public int getId() {
		return id;
	}

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
				+ "\n\nStrength: " + Strength 
				+ "\nDexterity: " + Dexterity 
				+ "\nConstitution: "	+ Constitution 
				+ "\nWisdom: " + Wisdom 
				+ "\nCharisma: " + Charisma 
				+ "\nIntelligence: "	+ Intelligence;
	}
	
	// default constructor
	public AdvCharacter(int id, int playerID, String name, String charClass, int strength,
			int dexterity, int constitution, int wisdom, int charisma, int intelligence, int experience) {
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
	}
	
	// unused method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
