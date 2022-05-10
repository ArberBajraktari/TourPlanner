package BusinessLayer;

import DatabaseAccessLayer.IDatabaseLayer;

import java.io.FileNotFoundException;

public class AppManagerFactory {
    private static AppManager manager;

    public static  AppManager GetManager(){
        if (manager == null){
            manager = new AppManagerImp();
        }
        return manager;
    }

}
