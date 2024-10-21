package MultiThreading.ThreadPoolPractice;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new CustomeThreadFactory(),  new CustomRejectHandler());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        for (int i=0; i<9; i++){
            threadPoolExecutor.submit(() -> {
                System.out.println("TaskProcessed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (Exception e){
                    //
                }

            });
        }


        threadPoolExecutor.shutdown();
        threadPoolExecutor.submit(() -> {
            System.out.println("Task submitted after 10 sec"+ Thread.currentThread().getName());
        });
    }
}


class CustomeThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MIN_PRIORITY);
        return thread;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected:  " + r.toString());
    }
}
