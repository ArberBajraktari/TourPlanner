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
    public void removeTour(TourModel tourModel) {
        System.out.println("Saving Tour into DB");
        int count = getMaxId() + 1;
        try {
            // Step 4: Create a statement
            String sql = "DELETE FROM Tours WHERE name = '" + tourModel.getTourName() + "';";

            PreparedStatement ps = con.prepareStatement(sql);
            // Step 6: Process the results
            System.out.println(ps.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTourDetails(String tourDesc, String tourFrom, String tourTo, String tourTransport, String tourDistance, String tourEstTime, String tourInfo, String tourName) throws SQLException {
        System.out.println(tourName);
        String sql = "UPDATE tours SET description = ?, \"from\" = ?, \"to\" = ?, transport_type = ?, distance = ?, estimated_time = ?, route_info = ? WHERE \"name\" = ?;";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, tourDesc);
        ps.setString(2, tourFrom);
        ps.setString(3, tourTo);
        ps.setString(4, tourTransport);
        ps.setString(5, tourDistance);
        ps.setString(6, tourEstTime);
        ps.setString(7, tourInfo);
        ps.setString(8, tourName);

        ps.executeUpdate();

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
