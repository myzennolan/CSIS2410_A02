package adventureApp;
/**
 * This is the Campaign class of the Adventure Database Application. 
 * These represent the campaigns that each player will play through 
 * within the application.
 * @author Trevor Hodson
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
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSetting() {
		return Setting;
	}

	public void setSetting(String setting) {
		Setting = setting;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getLevelLow() {
		return levelLow;
	}

	public void setLevelLow(int levelLow) {
		this.levelLow = levelLow;
	}

	public int getLevelHigh() {
		return levelHigh;
	}

	public void setLevelHigh(int levelHigh) {
		this.levelHigh = levelHigh;
	}

	public int getAvailableExp() {
		return availableExp;
	}

	public void setAvailableExp(int availableExp) {
		this.availableExp = availableExp;
	}

	public int getId() {
		return id;
	}
	//end of getters and setters

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
