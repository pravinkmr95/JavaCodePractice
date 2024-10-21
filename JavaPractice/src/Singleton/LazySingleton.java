package Singleton;

public class LazySingleton {
    private static LazySingleton lazySingletonObj;

    private LazySingleton(){
    }

    public static LazySingleton getInstance(){
        if (lazySingletonObj == null){
            lazySingletonObj = new LazySingleton();
        }
        return lazySingletonObj;
    }

}
