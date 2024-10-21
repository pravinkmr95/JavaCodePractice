package MultiThreading;

public class DaemonThread {
    private boolean isAvailable = false;

    public synchronized void producer(){
        try{
            Thread.sleep(10000);
            isAvailable = true;
        } catch (Exception e) {
           //throw new RuntimeException(e);
        }
        //Below statement won't run if this method is called with daemon
        for (int i=0; i < 10; i++){
            System.out.println("Number in producer " + i + " " + Thread.currentThread().getName());
        }
    }
}
