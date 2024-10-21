package Singleton;

public class Synchronised {
    private static Synchronised syncObject;

    private Synchronised(){
    }

    synchronized public static Synchronised getInstance(){
        if (syncObject == null){
            syncObject = new Synchronised();
        }
        return syncObject;
    }
}
