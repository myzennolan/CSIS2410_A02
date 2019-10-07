package database;

import adventureApp.Campaign;

public class sqlCampaign {

	/**
	 * 
	 * @return
	 */
	public static String selectAllCampaigns() {
		
		return "select * from campaign";
		
	}
	
	public static String selectCampaignByID(int id) {
		
		return "select * from campaign where id = "+id;
		
	}
	
	/**
	 * SQL Query for selecting all fields of a player
	 * 
	 * @return String "select *" SQL query "where"
	 */
	public static String deleteCampaignByID(int id) {
		
		return "delete from campaign where id = "+id;
		
	}
	
	public static String insertCampaign(Campaign campaign) {
		return ""
		        + "INSERT INTO campaign (Name, Setting, Description,LevelLow,LevelHigh,AvailableExp) "
		        + "VALUES "
		        + "('"
		        +campaign.getName()
		        +"', '"
		        +campaign.getSetting()
		        +"', '"
		        +campaign.getDescription()
		        +"',"
		        +campaign.getLevelLow()
		        +","
		        +campaign.getLevelHigh()
		        +","
		        +campaign.getAvailableExp()
		        +")";
	}
	
	public static String updateCampaign(Campaign campaign) {
		return ""
		        + "UODATE campaign SET"
		        + "Name = '"
		        +campaign.getName()
		        +"', Setting = '"
		        +campaign.getSetting()
		        +"', Description = '"
		        +campaign.getDescription()
		        +"', LevelLow = "
		        +campaign.getLevelLow()
		        +", LevelHigh = "
		        +campaign.getLevelHigh()
		        +", AvailableExp = "
		        +campaign.getAvailableExp()
		        +" WHERE id = " + campaign.getId();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
