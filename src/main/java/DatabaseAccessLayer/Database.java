package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Database implements IDatabaseLayer {

    private final String connectionString;

    public Database(String connectionString){
        this.connectionString = connectionString;
    }

    @Override
    public Connection createConnection() throws FileNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","myPassword");
        return DriverManager.getConnection(url, props);
    }

    @Override
    public void addTour(String tour) {
        System.out.println("Saving Tour into DB");
        System.out.println(tour);
    }


}
