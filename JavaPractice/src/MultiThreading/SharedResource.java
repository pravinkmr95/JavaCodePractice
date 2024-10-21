package MultiThreading;

public class SharedResource {
    boolean resourceAvailable = false;

    public synchronized void produce(){
        System.out.println("Inside product for thread " + Thread.currentThread().getName());
        resourceAvailable = true;
        notifyAll();
        System.out.println("After releasing producer lock");
    }

    public synchronized void consumerStock() {
        System.out.println("Inside consume for thread " + Thread.currentThread().getName());
        try{
            while (!resourceAvailable){
                wait();
            }
        } catch (Exception e){
            //
        }
        System.out.println("Producer lock released");
        resourceAvailable = false;
        System.out.println("resource out of stock");
    }
}
