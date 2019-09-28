package adventureApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import database.sqlCreate;
import database.sqlFill;
import database.sqlSelect;

public class console {

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    System.out.println(""
    		+ "The primary function of this database application is to serve as a role \r\n" + 
    		"playing game's catalog of players, their charcters, the character's experience\r\n" + 
    		"and equipment, and what capaigns they are currently involved in.\r\n" + 
    		"The application will allow for the creation of new players, new characters \r\n" + 
    		"for those players, new equipments, new campaigns, and allow the customization \r\n" + 
    		"of character levels universally by altering the level requirements for every \r\n" + 
    		"character in the system.");

    System.out.println();
    // Create
    if(true) {
/*
        executeStatement(sqlCreate.deleteTable("player"));
        executeStatement(sqlCreate.deleteTable("pcharacter"));
        executeStatement(sqlCreate.deleteTable("weapon"));
        executeStatement(sqlCreate.deleteTable("experience"));
        executeStatement(sqlCreate.deleteTable("campaign"));
        executeStatement(sqlCreate.deleteTable("CampaignCharacters"));
        executeStatement(sqlCreate.deleteTable("CharacterWeapons"));
  */      
    executeStatement(
      sqlCreate.tableCampaign(),
      sqlCreate.tableCharacter(),
      sqlCreate.tableExperience(),
      sqlCreate.tablePlayer(),
      sqlCreate.tableWeapon()
    );
    executeStatement(
      sqlCreate.tableCampaignCharacters(),
      sqlCreate.tableCharcterWeapons()
    );
    

    // "Truncate"
    executeStatement(sqlCreate.deleteAll("player"));
    executeStatement(sqlCreate.deleteAll("pcharacter"));
    executeStatement(sqlCreate.deleteAll("weapon"));
    executeStatement(sqlCreate.deleteAll("experience"));
    executeStatement(sqlCreate.deleteAll("campaign"));

    // Fill
    executeStatement(sqlFill.player());
    executeStatement(sqlFill.character());
    executeStatement(sqlFill.weapon());
    executeStatement(sqlFill.experience());
    executeStatement(sqlFill.campaign());
    }
    // Query
    executeQueries(
        sqlSelect.selectAll("Player"),
        sqlSelect.selectAll("PCharacter"),
        sqlSelect.selectAll("Experience"),
        sqlSelect.selectAll("Campaign"),
        sqlSelect.selectAll("Weapon")
    );
        
    System.out.println();
    System.out.println("Done!");
  }

  /**
   * Executes all the queries presented as arguments.
   * 
   * @param queries
   */
  private static void executeQueries(String... queries) {
    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;");
        Statement statement = connection.createStatement();) {

      for (String query : queries) {
        ResultSet results = statement.executeQuery(query);
        ResultSetMetaData metaData = results.getMetaData();
        int j = 1;
        while (results.next()) {
        	
        	if(j == 1) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
              System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();
            j++;
        	}
            
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(results.getObject(i) + "\t");
              }
              System.out.println();
        }

        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static void executeStatement(String... statements) {
    try (Connection connection = DriverManager.getConnection("jdbc:derby:adventure;create=true");
        Statement statement = connection.createStatement();) {

      for (String sqlStatement : statements) {
        statement.execute(sqlStatement);
      }

    } catch (SQLException e) {
        // Ignore 'table already exists' errors
        // if (e.getErrorCode() == 30000) {
        //     return;
        // }

        e.printStackTrace();
    }
  }
}
