package MultiThreadingLockTypes;

import java.util.Timer;
import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticResource {
    private int number = 10;
    StampedLock lock  = new StampedLock();

    public void producer(){
        System.out.println("Starting producer in thread " + Thread.currentThread().getName());
        long stamp = lock.tryOptimisticRead();
        int prev = number;
        try {
            System.out.println("Producer sleeps for 10 sec, so that number gets changed in between");
            //Thread.sleep(10000);
            System.out.println("Optimistic read for thread " + Thread.currentThread().getName() + " Trying to change the number value");
            number = 20;
            if (lock.validate(stamp)){
                System.out.println("Operation success. Number updated to " + number);
            } else {
                System.out.println("Number already changed by other thead. Rolling back..");
                number = prev;
            }
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
    }

    public void consumer(){
        System.out.println("Starting consumer in thread " + Thread.currentThread().getName());
        long stamp = lock.writeLock();
        try {
            //Thread.sleep();
            System.out.println("Write lock acquired for thread " + Thread.currentThread().getName());
            number = 1;
            System.out.println("Number changed to " + number);
        } catch (Exception e) {
            //throw new RuntimeException(e);
        } finally {
            lock.unlock(stamp);
        }
    }
}
