package MultiThreading.FuturePractice;

import java.util.concurrent.*;

public class CompletableFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->{
            System.out.println("Thread name in supplyAsync " + Thread.currentThread().getName());
            return "Hello ";
        }, threadPoolExecutor).thenApplyAsync((String x) -> {
            System.out.println("Thread name in thenApplyAsync " + Thread.currentThread().getName());
            return x + "World";
        }, threadPoolExecutor);
        System.out.println(completableFuture.get());

        // thenCompose for ordering

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside supply Async" + Thread.currentThread().getName());
            return "Hello";
        }, threadPoolExecutor).thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> {return val + " World1";}, threadPoolExecutor);
        });
        System.out.println(completableFuture1.get());

    }
}
