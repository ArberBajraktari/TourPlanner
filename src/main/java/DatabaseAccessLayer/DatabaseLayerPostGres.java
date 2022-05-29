package DatabaseAccessLayer;

import PresentationLayer.model.TourModel;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;


public class DatabaseLayerPostGres implements IDatabaseLayer {

    private Connection con;

    public DatabaseLayerPostGres(){
    }

    @Override
    public Connection createConnection() throws FileNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","Eridmilan12316");
        con = DriverManager.getConnection(url, props);
        return DriverManager.getConnection(url, props);
    }

    @Override
    public int getMaxId() {
        try {

            // Step 4: Create a statement
            String sql = "SELECT max(id) FROM tours";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            ps.execute();
            ResultSet last_updated_person = ps.getResultSet();
            if(last_updated_person.next()) {
                return last_updated_person.getInt(1);
            }
            else{
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void removeTour(TourModel tourModel) {
        System.out.println("Saving Tour into DB");
        int count = getMaxId() + 1;
        try {
            // Step 4: Create a statement
            String sql = "DELETE FROM tours WHERE name = '" + tourModel.getTourName() + "';";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTour(String tour) {
        System.out.println("Saving Tour into DB");
        int count = getMaxId() + 1;
        try {
            // Step 4: Create a statement
            String sql = "insert into tours values("+ count +", '" + tour +"')";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
