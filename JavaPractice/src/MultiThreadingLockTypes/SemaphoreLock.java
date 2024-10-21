package MultiThreadingLockTypes;

public class SemaphoreLock {
    public static void main(String[] args) {
        SemaphoreResource semaphoreResource = new SemaphoreResource();
        for (int i=0; i<7; i++) {
            new Thread(() -> {
                semaphoreResource.producer();
                ;
            }).start();
        }

//        Thread thread2 = new Thread(() -> {
//            semaphoreResource.producer();;
//        });
//
//        Thread thread3 = new Thread(() -> {
//            semaphoreResource.producer();;
//        });
//
//        Thread thread4 = new Thread(() -> {
//            semaphoreResource.producer();;
//        });
//
//        Thread thread5 = new Thread(() -> {
//            semaphoreResource.producer();;
//        });
    }
}
