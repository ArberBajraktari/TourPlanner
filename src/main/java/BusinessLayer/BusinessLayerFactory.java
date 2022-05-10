package BusinessLayer;

public class BusinessLayerFactory {
    private static IBusinessLayer manager;

    public static IBusinessLayer GetManager(){
        if (manager == null){
            manager = new BusinessLayerImp();
        }
        return manager;
    }

}
