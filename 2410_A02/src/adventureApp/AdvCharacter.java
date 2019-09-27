package adventureApp;

public class AdvCharacter {
	private int id;// int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10, INCREMENT BY 1), \r\n" + 
	private int playerID;// int, \r\n" + 
	private String Name;// varchar(255), \r\n" + 
	private String CharClass;// varchar(255), \r\n" + 
	private int Experience;// int, \r\n" + 
	private int Strength;// int, \r\n" + 
	private int Dexterity;// int, \r\n" + 
	private int Constitution;// int, \r\n" + 
	private int Wisdom;// int, \r\n" + 
	private int Charisma;// int, \r\n" + 
	private int Intelligence;// int, \r\n" + 
	
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

	public AdvCharacter() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
