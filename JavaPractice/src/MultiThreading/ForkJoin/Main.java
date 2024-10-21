package MultiThreading.ForkJoin;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long t1 = System.currentTimeMillis();
        //ForkJoinPractice forkJoinPracticeSum = new ForkJoinPractice(0, 100000000);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //ExecutorService forkJoinPool = Executors.newWorkStealingPool(4);
        Future<Integer> futureObj = forkJoinPool.submit(new ForkJoinPractice(0, 100000000));
        System.out.println("Sum == " + futureObj.get());

        System.out.println("time take for Sum using fork join " + (System.currentTimeMillis() - t1));

        long t2 = System.currentTimeMillis();
        int sum=0;
        for (int i =0; i<=100000000; i++){
            sum += i;
        }
        System.out.println("Sum == " + sum);
        System.out.println("time taken for Sum using loop " + (System.currentTimeMillis() - t2));

    }
}
