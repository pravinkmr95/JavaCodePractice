package MultiThreadingLockTypes;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadWriteSharedResource sharedResource1 = new ReadWriteSharedResource();
        ReadWriteSharedResource sharedResource2 = new ReadWriteSharedResource();
        ReadWriteSharedResource sharedResource3 = new ReadWriteSharedResource();
        ReadWriteSharedResource sharedResource4 = new ReadWriteSharedResource();
        Thread thread1 = new Thread(() -> {
            sharedResource1.producer(readWriteLock);
        });

        Thread thread2 = new Thread(() -> {
            sharedResource2.producer(readWriteLock);
        });

        Thread thread3 = new Thread(() -> {
            sharedResource3.consumer(readWriteLock);
        });

        Thread thread4 = new Thread(() -> {
            sharedResource4.consumer(readWriteLock);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
