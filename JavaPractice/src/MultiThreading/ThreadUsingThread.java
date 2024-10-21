package MultiThreading;

public class ThreadUsingThread extends Thread{
    @Override
    public void run(){
        for (int i=0; i < 5; i++){
            System.out.println("printing i = " + i + " from thread " + Thread.currentThread().getName());
        }
    }
}
