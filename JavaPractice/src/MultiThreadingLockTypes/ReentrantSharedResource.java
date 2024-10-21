package MultiThreadingLockTypes;


import java.util.concurrent.locks.ReentrantLock;

public class ReentrantSharedResource {
    private boolean isAvailable = false;
    private ReentrantLock lock;

    ReentrantSharedResource(ReentrantLock lock){
        this.lock = lock;
    }

    public void producer(String resourceName){
        try {
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Resource name: " + resourceName + " Lock acquired by Thread" + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(1000);
        } catch (Exception e) {
            // throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
