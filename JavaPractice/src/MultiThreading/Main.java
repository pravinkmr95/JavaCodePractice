package MultiThreading;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Running main thread " + Thread.currentThread().getName());
//        ThreadUsingRunnable threadUsingRunnable = new ThreadUsingRunnable();
//
//        for (int i=0;i<3;i++){
//            //Thread.sleep(500);
//            Thread thread = new Thread(threadUsingRunnable);
//            thread.start();
//
//        }
//        //Thread.sleep(5000);
//        ThreadUsingThread obj = new ThreadUsingThread();
//        obj.start();
//        System.out.println("Main finished");
        Factorial factorial = new Factorial();

        Thread thread = new Thread(() -> {
            factorial.getFactorial(10);
        });

        Thread thread1 = new Thread(() -> {
            factorial.getFactorial(15);
        });
        LocalDateTime d1 = LocalDateTime.now();
        thread1.start();
        thread.start();
        LocalDateTime d2 = LocalDateTime.now();
        System.out.println("Duration between times " + Duration.between(d1, d2).getNano());

    }
}
