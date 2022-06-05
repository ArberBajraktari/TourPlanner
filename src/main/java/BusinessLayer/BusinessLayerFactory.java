package BusinessLayer;

public class BusinessLayerFactory {
    private static IBusinessLayer manager;

    //Singleton for the Business Layer
    public static IBusinessLayer GetManager(){
        if (manager == null){
            manager = new BusinessLayerImp();
        }
        return manager;
    }

}
