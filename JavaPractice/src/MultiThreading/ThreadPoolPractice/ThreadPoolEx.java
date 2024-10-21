package MultiThreading.ThreadPoolPractice;

import java.util.concurrent.*;

public class ThreadPoolEx {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                    new CustomExecutionHandler());
            // Executors.defaultThreadFactory()
            // new ThreadPoolExecutor.DiscardPolicy()

            threadPoolExecutor.allowCoreThreadTimeOut(true);
            for (int i=0; i<8; i++){
                threadPoolExecutor.submit(() -> {
                    System.out.println("TaskProcessed by " + Thread.currentThread().getName());
                    try{
                        Thread.sleep(5000);
                    } catch (Exception e){
                        //
                    }
                    //System.out.println("Inside thread " + Thread.currentThread().getName());
                });
            }
        } catch (RuntimeException e) {
            //throw new RuntimeException(e);
        }
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(false);
        return thread;
    }
}

class CustomExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Rejected task: " + r.toString());
    }
}
