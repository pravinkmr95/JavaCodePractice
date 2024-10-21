package MultiThreading;

public class MonitorLocks {
    public synchronized void method1() {
        System.out.println("Inside method1 for thread " + Thread.currentThread().getName());
        System.out.println("Waiting for 10 sec");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex){
            //
        }
        System.out.println("...Waiting complete...");

    }

    public void method2(){
        System.out.println("Before sync in method2 for thread " + Thread.currentThread().getName());
        synchronized (this){
            System.out.println("Inside sync in method2 for thread " + Thread.currentThread().getName());
        }
    }

    public void method3(){
        System.out.println("Method3 " + Thread.currentThread().getName());
    }
}
