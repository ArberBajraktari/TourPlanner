package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database implements IDatabaseLayer {

    private final String connectionString;

    public Database(String connectionString){
        this.connectionString = connectionString;
    }

    private Connection CreateConnection() throws SQLException, FileNotFoundException {
        String usernameString = ConfigurationManager.GetConfigProperty("PostgresSqlUsername");
        String pwdString = ConfigurationManager.GetConfigProperty("PostgresSqlPwd");
        try {
            return DriverManager.getConnection(connectionString, usernameString, pwdString);
        } catch (SQLException e){
            Logger log = LogManager.getLogger(Database.class);
            log.error("Establishing connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        throw new SQLException("Establishing connection failed.");
    }

}
