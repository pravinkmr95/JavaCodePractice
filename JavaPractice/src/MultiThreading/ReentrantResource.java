package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantResource {
    private boolean isAvailable = false;

    public void producer(ReentrantLock lock){
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Lock acquired for thread " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e){
            //
        } finally {
            lock.unlock();
            System.out.println("Unlocked for thread " + Thread.currentThread().getName());
        }
    }
}
