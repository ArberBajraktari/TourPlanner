package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import PresentationLayer.model.TourLogCellModel;
import PresentationLayer.model.TourModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class DatabaseLayerPostGres implements IDatabaseLayer {

    private Connection con;

    public DatabaseLayerPostGres(){
    }

    @Override
    public Connection createConnection() throws FileNotFoundException, SQLException {
        String url = ConfigurationManager.GetConfigProperty("PostgresSqlConnectionString");
        String user = ConfigurationManager.GetConfigProperty("user");
        String password = ConfigurationManager.GetConfigProperty("pwd");
        Properties props = new Properties();
        props.setProperty("user",user);
        props.setProperty("password",password);
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
    public int getMaxIdLog() {
        try {

            // Step 4: Create a statement
            String sql = "SELECT max(id) FROM tours_logs";

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
    public int getIdFromName(String name) {
        try {

            // Step 4: Create a statement
            String sql = "SELECT id FROM Tours where name = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            // Step 6: Process the results
            ps.execute();
            ResultSet last_updated_person = ps.getResultSet();
            if(last_updated_person.next()) {
                return last_updated_person.getInt("id");
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
    public void updateTourDetails(String tourDesc, String tourFrom, String tourTo, String tourTransport, String tourDistance, String tourEstTime, String tourInfo, String tourName, int tourRating) throws SQLException {
        String sql = "UPDATE tours SET description = ?, \"from\" = ?, \"to\" = ?, transport_type = ?, distance = ?, estimated_time = ?, route_info = ?, ratings = ?  WHERE \"name\" = ?;";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, tourDesc);
        ps.setString(2, tourFrom);
        ps.setString(3, tourTo);
        ps.setString(4, tourTransport);
        ps.setString(5, tourDistance);
        ps.setString(6, tourEstTime);
        ps.setString(7, tourInfo);
        ps.setInt(8, tourRating);
        ps.setString(9, tourName);

        ps.executeUpdate();
    }

    @Override
    public void updateTourLog(TourLogCellModel item, String tourModelName) {
        String sql = "UPDATE tours_logs SET comment = ?, difficulty = ?, total_time = ?, rating = ?  WHERE \"date\" = ?;";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, item.getComment());
            ps.setString(2, item.getDifficulty());
            ps.setString(3, item.getTotalTime());
            ps.setString(4, item.getRating());
            ps.setString(5, item.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeTourLog(TourLogCellModel tourLogCellModel) {
        try {
            // Step 4: Create a statement
            String sql = "DELETE FROM tours_logs WHERE \"date\" = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tourLogCellModel.getDate());
            // Step 6: Process the results
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<TourLogCellModel> getAllTourLogs(String tourName) {
        try {
            // Step 4: Create a statement
            String sql = "SELECT * FROM tours_logs where tour_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, getIdFromName(tourName));
            ResultSet rs = ps.executeQuery();
            ObservableList<TourLogCellModel> tourLogs = FXCollections.observableArrayList();
            TourLogCellModel temp;
            while (rs.next()){
                System.out.println("item x");
                temp = new TourLogCellModel();
                temp.setDate(rs.getString("date"));
                temp.setComment(rs.getString("comment"));
                temp.setDifficulty(rs.getString("difficulty"));
                temp.setTotalTime(rs.getString("total_time"));
                temp.setRating(rs.getString("rating"));
                tourLogs.add(temp);
            }
            return tourLogs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ObservableList<TourModel> getAllTours() {
        try {

            // Step 4: Create a statement
            String sql = "SELECT * FROM Tours";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ObservableList<TourModel> tours = FXCollections.observableArrayList();
            TourModel temp;
            while (rs.next()){
                temp = new TourModel();
                temp.setTourName(rs.getString("name"));
                temp.setTourDesc(rs.getString("description"));
                temp.setTourFrom(rs.getString("from"));
                temp.setTourTo(rs.getString("to"));
                temp.setTourTransport(rs.getString("transport_type"));
                temp.setTourDistance(rs.getString("distance"));
                temp.setTourEstTime(rs.getString("estimated_time"));
                temp.setTourInfo(rs.getString("route_info"));
                temp.setTourRating(rs.getInt("ratings"));
                tours.add(temp);
            }
            return tours;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getAllToursNames() {
        try {

            // Step 4: Create a statement
            String sql = "SELECT \"name\" FROM Tours";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<String> toursNames = new ArrayList<>();
            while (rs.next()){
                toursNames.add(rs.getString("name"));
            }
            return toursNames;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveTourLogs(TourLogCellModel item, String tourModelName) {

        if(tourLogExists(item.getDate())){
            updateTourLog(item, tourModelName);
        }else{
            // Step 4: Create a statement
            String sql = "Insert into tours_logs values(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);

                ps.setInt(1, getMaxIdLog()+1);
                ps.setInt(2, getIdFromName(tourModelName));
                ps.setString(3, item.getDate());
                ps.setString(4, item.getComment());
                ps.setString(5, item.getDifficulty());
                ps.setString(6, item.getTotalTime());
                ps.setString(7, item.getRating());
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean tourLogExists(String date) {
        try {
            // Step 4: Create a statement
            String sql = "SELECT id FROM tours_logs where \"date\" = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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
