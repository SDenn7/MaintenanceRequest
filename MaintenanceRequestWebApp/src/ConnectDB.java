
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author samanthadennison <your.name your.org>
 */

public class ConnectDB {
    private static Connection connection;
    // The username for the database
    private static final String user = "CMPSC487";
    // The password to access the database
    private static final String password = "CMPSC487";
    // Address of the database
    private static final String database = "jdbc:derby://localhost:1527/MaintenanceRequestDB";

    public static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(database, user, password);
            } catch (SQLException e)
            {
                e.printStackTrace();
                System.out.println("Could not open database.");
                System.exit(1);

            }
        }
        return connection;
    }
    
}
