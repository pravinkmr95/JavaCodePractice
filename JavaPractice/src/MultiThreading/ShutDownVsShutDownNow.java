package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownVsShutDownNow {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        executorService.submit(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Inside thread " + Thread.currentThread().getName());
//        });
//
//        executorService.shutdown();
//        System.out.println(executorService.awaitTermination(5, TimeUnit.SECONDS));
//        System.out.println("After shutdown-> main");



        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        executorService1.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                System.out.println("Throwing interrupted exception");
                //throw new RuntimeException(e);
            }
            System.out.println("Inside thread ");
        });

        executorService1.shutdownNow(); // throws interrupted exception
        System.out.println("After shutdown-> main");
    }
}
