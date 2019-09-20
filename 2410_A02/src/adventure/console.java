package adventure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.sqlCreate;
import database.sqlSelect;

public class console {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		System.out.println();
		/*  === Create Tables
		executeStatement(
				//sqlCreate.tableCampaign(),
				//sqlCreate.tableCharacter(),
				//sqlCreate.tableExperience(),
				//sqlCreate.tablePlayer(),
				//sqlCreate.tableWeapon()
				);
		executeStatement(
				//sqlCreate.tableCampaignCharacters(),
				//sqlCreate.tableCharcterWeapons()
				);
		System.out.println();
		*/
		
		executeQueries(
				sqlSelect.selectAll("Player"),
				sqlSelect.selectAll("PCharacter"),
				sqlSelect.selectAll("Experience"),
				sqlSelect.selectAll("Campaign"),
				sqlSelect.selectAll("Weapon")
				);
		
		System.out.println("Done!");
	}

	/**
	 * Executes all the queries presented as arguments.
	 * 
	 * @param queries
	 */
	private static void executeQueries(String... queries) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:adventure");
				Statement statement = connection.createStatement();){
				
				for(String query:queries) {
				ResultSet results = statement.executeQuery(query);
				ResultSetMetaData metaData = results.getMetaData();
				
					while(results.next()) {
						
						for(int i = 1; i <= metaData.getColumnCount(); i++) {
							System.out.print(results.getObject(i).toString()+"\t");
						}
						System.out.println();
					}
					
					System.out.println();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	private static void executeStatement(String... statements) {
		try(Connection connection = DriverManager.getConnection("jdbc:derby:adventure;create=true");
				Statement statement = connection.createStatement();){
				
			for(String sqlStatement:statements) {
				statement.execute(sqlStatement);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
