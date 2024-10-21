package MultiThreading;

public class ThreadUsingRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("printing i = " + i + " from thread " + Thread.currentThread().getName());
        }
    }
}
