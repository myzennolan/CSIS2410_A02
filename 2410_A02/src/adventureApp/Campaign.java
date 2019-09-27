package adventureApp;

public class Campaign {
	private int id;
	private String Name;
	private String Setting;
	private String Description;
	private int levelLow;
	private int levelHigh; 
	private int availableExp;
	
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

	public Campaign() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
