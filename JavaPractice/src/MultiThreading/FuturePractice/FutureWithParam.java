package MultiThreading.FuturePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureWithParam {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        List<Integer> array = new ArrayList<>();
        Future<List<Integer>> futureObj = threadPoolExecutor.submit(() -> {
            System.out.println("Inside thread " + Thread.currentThread().getName());
            array.add(10);
            array.add(1000);
            // List<Integer> array1 = new ArrayList<>();
        }, array);

        futureObj.get();
        System.out.println(array.get(1));
    }
}
