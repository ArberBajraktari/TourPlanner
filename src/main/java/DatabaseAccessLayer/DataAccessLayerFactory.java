package DatabaseAccessLayer;

public class DataAccessLayerFactory {
    private static IDatabaseLayer databaseLayer;

    public static IDatabaseLayer getDatabase(){
        if (databaseLayer == null) {
            databaseLayer = new DatabaseLayerPostGres();

        }
        return databaseLayer;
    }
}
