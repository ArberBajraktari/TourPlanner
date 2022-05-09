package BusinessLayer;

import DatabaseAccessLayer.IDatabaseLayer;

public class AppManagerFactory {
    private static AppManager manager;

    public static  AppManager GetManager() {
        if (manager == null){
            manager = new AppManagerImp();
        }
        return manager;
    }

}
