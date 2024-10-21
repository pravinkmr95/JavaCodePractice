package MultiThreadingLockTypes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteSharedResource {
    private boolean isAvailable;

    public void producer(ReadWriteLock lock){
        try{
            //Thread.sleep(1000);
            // System.out.println("Going to acquire read lock " + Thread.currentThread().getName());
            System.out.println("Acquired read lock " + Thread.currentThread().getName());
            lock.readLock().lock();
            Thread.sleep(8000);
        } catch (Exception e){
            //
        } finally {
            lock.readLock().unlock();
            System.out.println("Read lock released by thread " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try {
            // System.out.println("Going to write lock for thread " + Thread.currentThread().getName());
            lock.writeLock().lock();
            System.out.println("write Lock acquired for thread " + Thread.currentThread().getName());
            isAvailable = false;
            //Thread.sleep(3000);

        } catch (Exception e) {
            //
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
