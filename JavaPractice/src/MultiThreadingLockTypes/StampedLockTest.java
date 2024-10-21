package MultiThreadingLockTypes;

public class StampedLockTest {
    public static void main(String[] args) {
//        StampedLockSharedResource stampedLockSharedResource = new StampedLockSharedResource();
//        Thread consumerThread = new Thread(() -> {
//            stampedLockSharedResource.consumer();
//        });
//
//        Thread producerThread = new Thread(() -> {
//            stampedLockSharedResource.producer();
//        });
//
//        consumerThread.start();
//        producerThread.start();

        // optimistic locking
        StampedOptimisticResource stampedOptimisticResource = new StampedOptimisticResource();
        Thread thread1 = new Thread(() -> {
            stampedOptimisticResource.producer();
        });

//        Thread thread2 = new Thread(() -> {
//            stampedOptimisticResource.consumer();
//        });

        thread1.start();
        //thread2.start();
    }
}
