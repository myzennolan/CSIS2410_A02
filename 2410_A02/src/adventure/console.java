package adventure;

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
    System.out.println();

    // Create
    if(true) {

        executeStatement(sqlCreate.deleteTable("player"));
        executeStatement(sqlCreate.deleteTable("pcharacter"));
        executeStatement(sqlCreate.deleteTable("weapon"));
        executeStatement(sqlCreate.deleteTable("experience"));
        executeStatement(sqlCreate.deleteTable("campaign"));
        executeStatement(sqlCreate.deleteTable("CampaignCharacters"));
        executeStatement(sqlCreate.deleteTable("CharacterWeapons"));
        
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

    // Fill
    executeStatement(sqlFill.player());
    executeStatement(sqlFill.character());
    executeStatement(sqlFill.weapon());
    executeStatement(sqlFill.experience());
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
