package MultiThreading.FuturePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureWithCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        List<Integer> array = new ArrayList<>();
        Future<List<Integer>> futureObj = threadPoolExecutor.submit(() -> {
            System.out.println("Adding number in an array for thread "+ Thread.currentThread().getName());
            array.add(100);
            array.add(100);
            return array;
        });
        List<Integer> array1 = futureObj.get();
        System.out.println(array== array1);
        System.out.println(array);
    }
}
