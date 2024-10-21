package MultiThreadingLockTypes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private boolean isAvailable=false;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void producer(){

        try{
            lock.lock();
            System.out.println("Lock acquired by producer thread " + Thread.currentThread().getName());
            if (isAvailable){
                System.out.println("Produce thread is waiting");
                condition.await();
            }
            isAvailable = true;
            condition.signalAll();
            System.out.println("product available");
        } catch (Exception e){
            //
        } finally {
            lock.unlock();
            System.out.println("producer lock released");
        }
    }

    public void consumer(){

        try {
            lock.lock();
            System.out.println("Lock acquired by consumer thread " + Thread.currentThread().getName());
            if (!isAvailable){
                System.out.println("Consumer thread waiting");
                condition.await();
            }
            isAvailable = false;
            condition.signalAll();
            System.out.println("product consumed");
        } catch (Exception e) {
            //
        } finally {
            lock.unlock();
            System.out.println("Consumer lock released");
        }
    }
}
