package BusinessLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapQuestManager {

    public static String requestRoute(String start, String end){
        HttpURLConnection connection = null;
        try{
            URL url = new URL("http://www.mapquestapi.com/directions/v2/route?key=KEY&from=Clarendon Blvd,Arlington,VA&to=2400+S+Glebe+Rd,+Arlington,+VA");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestMethod("Content-Type," +
                    "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length",
                    Integer.toString(0));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes("");
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            Logger log = LogManager.getLogger(MapQuestManager.class);
            log.error("Request route failed");
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    public static BufferedImage requestRouteImage(String start, String end){
        Logger log = LogManager.getLogger(MapQuestManager.class);
        String jsonString =requestRoute(start, end);
        if(jsonString == null) {
            log.error("JsonObject is null");
            return null;
        }
        JSONObject obj
    }
}
