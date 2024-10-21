package MultiThreading;

public class SharedResourcePractice {
    private boolean isAvailable = false;

    public synchronized void producer(){
        System.out.println("inside producer using thread " + Thread.currentThread().getName());
        isAvailable = true;
        notifyAll();
    }

    public synchronized void consumer(){
        System.out.println("Inside consumer with thread " + Thread.currentThread().getName());
        try {
            System.out.println("Before consuming. Waiting for availability");
            while (!isAvailable) {
                wait();
            }
            System.out.println("After consuming");
        } catch (Exception e){
            //
        }
        isAvailable = false;
    }
}
