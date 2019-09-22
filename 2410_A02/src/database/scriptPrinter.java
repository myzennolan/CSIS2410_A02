package database;

/**
 * Prints scripts in a easier to copy/paste format
 * 
 * @author Nolan Harris, Trevor Hodsdon, Dominick Wiley
 *
 */
public class scriptPrinter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqlCreate.tableCampaign());
		System.out.println(sqlCreate.tableCampaignCharacters());
		System.out.println(sqlCreate.tableCharacter());
		System.out.println(sqlCreate.tableCharcterWeapons());
		System.out.println(sqlCreate.tableExperience());
		System.out.println(sqlCreate.tablePlayer());
		System.out.println(sqlCreate.tableWeapon());
		
	}

}
