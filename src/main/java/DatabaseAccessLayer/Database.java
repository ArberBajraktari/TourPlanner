package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;


public class Database implements IDatabaseLayer {

    private final String connectionString;
    private Connection con;

    public Database(String connectionString){
        this.connectionString = connectionString;
    }

    @Override
    public Connection createConnection() throws FileNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","myPassword");
        con = DriverManager.getConnection(url, props);
        return DriverManager.getConnection(url, props);
    }

    @Override
    public int getMaxId() {
        try {

            // Step 4: Create a statement
            String sql = "SELECT max(id) FROM Tours";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            ps.execute();
            ResultSet last_updated_person = ps.getResultSet();
            if(last_updated_person.next()) {
                return last_updated_person.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void addTour(String tour) {
        System.out.println("Saving Tour into DB");
        int count = getMaxId() + 1;
        try {
            // Step 4: Create a statement
            String sql = "insert into Tours values("+ count +", '" + tour +"')";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
