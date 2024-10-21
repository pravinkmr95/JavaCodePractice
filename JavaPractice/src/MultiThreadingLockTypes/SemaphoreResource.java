package MultiThreadingLockTypes;

import java.util.concurrent.Semaphore;

public class SemaphoreResource {
    private boolean isAvailable;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try {
            lock.acquire();
            System.out.println("Lock acquired by thread " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e){
            //
        } finally {
            lock.release();
            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }

    }
}
