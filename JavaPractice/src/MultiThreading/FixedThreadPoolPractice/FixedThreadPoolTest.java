package MultiThreading.FixedThreadPoolPractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {
    public static void main(String[] args) {

        // newFixedThreadPool
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // Inside package java.util.concurrent
        // Min & max -> Same = 5
        // Queue size -> Unbounded -> LinkedList -> until memory issue
        // Thread Alive when Idle-> yes
        // When to use -> if we already know how many async tasks are needed
        // Disadvantage -> when workload is heavy

        executorService.submit(() -> System.out.println("thread " + Thread.currentThread().getName()));

        executorService.close();

        // newCachedThreadPool

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        // creates a thread pool when needed(dynamically)
        // min threads-> 0
        // Max threads -> Integer.MAX_VALUE
        //Queue size -> Blocking queue with size=0
        //Thread alive when Idle-> 60 sec
        // when to use -> Handling burst of short-lived tasks
        // Disadvantage-> increased memory usage due to long-lived tasks.

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        // single thread
        // task performed sequentially
        // no concurrency-> less used

        // Work Stealing Pool
        ExecutorService executorService3 = Executors.newWorkStealingPool();
    }
}
