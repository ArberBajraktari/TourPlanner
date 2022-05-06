package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;



public class DataAccessLayerFactory {
    private static IDatabaseLayer databaseLayer;

    public static IDatabaseLayer GetDatabase() throws FileNotFoundException {
        if (databaseLayer == null) {
            databaseLayer = CreateDatabase();
        }
        return databaseLayer;
    }

    private static IDatabaseLayer CreateDatabase() throws FileNotFoundException {
        String connectionString = ConfigurationManager.GetConfigProperty("PostgresSqlConnectionString");
        return CreateDatabase(connectionString);
    }
    private static IDatabaseLayer CreateDatabase(String connectionString) {
        try {
            Class<Database> cls = (Class<Database>) Class.forName(Database.class.getName());
            return cls.getConstructor(String.class).newInstance(connectionString);
        } catch (Exception e) {
            Logger log = LogManager.getLogger(DataAccessLayerFactory.class);
            log.error("Cant create Database: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
