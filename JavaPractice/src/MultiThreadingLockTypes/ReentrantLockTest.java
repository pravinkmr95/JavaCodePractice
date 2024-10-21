package MultiThreadingLockTypes;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        ReentrantSharedResource reentrantSharedResource1 = new ReentrantSharedResource(reentrantLock);

        ReentrantSharedResource reentrantSharedResource2 = new ReentrantSharedResource(reentrantLock);

        Thread thread1 = new Thread(() -> {
            //System.out.println("Inside producer thread " + Thread.currentThread().getName());
            reentrantSharedResource1.producer("<resource 1>");
        });

        Thread thread2 = new Thread(() -> {
            //System.out.println("Inside producer thread " + Thread.currentThread().getName());
            reentrantSharedResource2.producer("<resource 2>");
        });

        thread1.start();
        thread2.start();
    }
}
