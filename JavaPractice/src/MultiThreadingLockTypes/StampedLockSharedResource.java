package MultiThreadingLockTypes;

import java.util.concurrent.locks.StampedLock;

public class StampedLockSharedResource {
    private int number = 10;
    private StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.readLock();
        try {
            System.out.println("Stamped Read lock acquired for thread " + Thread.currentThread().getName());
        } catch (Exception e) {
            //throw new RuntimeException(e);
        } finally {
            lock.unlock(stamp);
            System.out.println("Read lock released for thread " + Thread.currentThread().getName());
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        try {
            System.out.println("Write lock acquired for thread " + Thread.currentThread().getName());
            number = 11;
        } catch (Exception e){
            //
        } finally {
            lock.unlock(stamp);
            System.out.println("Write lock released for thread " + Thread.currentThread().getName());
        }
    }
}
