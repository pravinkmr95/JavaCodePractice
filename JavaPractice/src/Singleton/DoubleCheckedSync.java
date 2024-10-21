package Singleton;

public class DoubleCheckedSync {
    private static volatile DoubleCheckedSync doubleCheckedSyncObj;

    private DoubleCheckedSync(){
    }

    public static DoubleCheckedSync getInstance(){
        if (doubleCheckedSyncObj == null){
            synchronized (DoubleCheckedSync.class){
                if (doubleCheckedSyncObj == null){
                    doubleCheckedSyncObj = new DoubleCheckedSync();
                }
            }
        }
        return doubleCheckedSyncObj;
    }
}
