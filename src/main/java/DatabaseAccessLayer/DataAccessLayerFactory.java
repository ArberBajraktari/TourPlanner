package DatabaseAccessLayer;

import BusinessLayer.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class DataAccessLayerFactory {
    private static IDatabaseLayer databaseLayer;

    public static IDatabaseLayer getDatabase(){
        if (databaseLayer == null) {
            databaseLayer = new Database("PostgresSqlConnectionString");
        }
        return databaseLayer;
    }
}
