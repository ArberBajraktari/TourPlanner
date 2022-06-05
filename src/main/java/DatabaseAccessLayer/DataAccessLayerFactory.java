package DatabaseAccessLayer;

public class DataAccessLayerFactory {
    private static IDatabaseLayer databaseLayer;

    //Singleton for the Database Layer
    public static IDatabaseLayer getDatabase(){
        if (databaseLayer == null) {
            databaseLayer = new DatabaseLayerPostGres();
        }
        return databaseLayer;
    }
}
