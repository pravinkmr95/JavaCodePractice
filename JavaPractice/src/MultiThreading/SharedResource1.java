package MultiThreading;

public class SharedResource1 {
    private boolean isAvailable = false;

    public synchronized void produce(){
        System.out.println("Lock acquired by Thread " + Thread.currentThread().getName());
        try {
            isAvailable = true;
            Thread.sleep(4000);
            System.out.println("Lock Released by Thread " + Thread.currentThread().getName());
        } catch (Exception e){

        }

    }
}
