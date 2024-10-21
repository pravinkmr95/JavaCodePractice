package Singleton;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        LazySingleton obj = LazySingleton.getInstance();
        LazySingleton obj1 = LazySingleton.getInstance();
        System.out.println(obj == obj1);

        EagerSingleton object = EagerSingleton.getInstance();
        EagerSingleton object1 = EagerSingleton.getInstance();

        System.out.println(object == object1);

        Synchronised syncObj = Synchronised.getInstance();
        Synchronised syncObj1 = Synchronised.getInstance();

        System.out.println(syncObj1 == syncObj);

        DoubleCheckedSync doubleCheckedSync = DoubleCheckedSync.getInstance();
        DoubleCheckedSync doubleCheckedSync1 = DoubleCheckedSync.getInstance();
        System.out.println(doubleCheckedSync1 == doubleCheckedSync);

        Connection enumSingleton = DBInstanceEnum.INSTANCE.getConnection();
        System.out.println(enumSingleton);
    }
}
