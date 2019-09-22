package database;

/**
 * Repository of table selection script/s
 * 
 * @author Nolan Harris, Trevor Hodsdon, Dominick Wiley
 *
 */
public class sqlSelect {
	
	/**
	 * Select all records from any provided table
	 * 
	 * @param table 
	 * @return select * from table
	 */
	public static String selectAll(String table) {
		
		return "select * from "+table;
		
	}
}
