package database;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
