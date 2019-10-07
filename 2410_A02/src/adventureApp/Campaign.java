package adventureApp;
/**
 * This is the Campaign class of the Adventure Database Application. 
 * These represent the campaigns that each player will play through 
 * within the application.
 * 
 * @author Nolan Harris, Trevor Hodson, and Dominick Wiley
 *
 */
public class Campaign {
	private int id;
	private String Name;
	private String Setting;
	private String Description;
	private int levelLow;
	private int levelHigh; 
	private int availableExp;
	
	// getters and setters

	/**
	 * Returns the name of the Campaign. 
	 * 
	 * @return Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Returns the setting of the Campaign.
	 * 
	 * @return Level
	 */
	public String getSetting() {
		return Setting;
	}


	/**
	 * Returns the description of the Campaign.
	 * 
	 * @return Level
	 */
	public String getDescription() {
		return Description;
	}


	/**
	 * Returns the minimum level requirement of the campaign.
	 * 
	 * @return Level
	 */
	public Integer getLevelLow() {
		return levelLow;
	}

	/**
	 * Returns the maximum level of the campaign where a character can still earn experience.
	 * 
	 * @return Level
	 */
	public Integer getLevelHigh() {
		return levelHigh;
	}

	/**
	 * Returns the experience vailable to characters in the level range of the campaign.
	 * 
	 * @return Level
	 */
	public Integer getAvailableExp() {
		return availableExp;
	}

	/**
	 * Returns the id of the Campaign. 
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	//end of getters and setters

	/**
	 * Instantiates a new Campaign.
	 * @param id
	 * @param name
	 * @param setting
	 * @param description
	 * @param levelLow
	 * @param levelHigh
	 * @param availableExp
	 */
	public Campaign(int id, String name, String setting, String description, int levelLow, int levelHigh,
			int availableExp) {
		super();
		this.id = id;
		Name = name;
		Setting = setting;
		Description = description;
		this.levelLow = levelLow;
		this.levelHigh = levelHigh;
		this.availableExp = availableExp;
	}

	// unused method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
