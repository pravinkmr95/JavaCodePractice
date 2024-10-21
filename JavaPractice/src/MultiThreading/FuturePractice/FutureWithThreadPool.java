package MultiThreading.FuturePractice;

import java.util.concurrent.*;

public class FutureWithThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        Future<?> futureObj = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }
            System.out.println("Task completed " + Thread.currentThread().getName());
        });


        try {
            futureObj.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("Runtime exception");

        }
        futureObj.get();
        System.out.println("Task completed? " + futureObj.isDone());
        System.out.println("Cancelled? " + futureObj.isCancelled());

        Object object = futureObj.get();
        if (object == null){
            System.out.println("Returned type of future object is null");
        }
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
