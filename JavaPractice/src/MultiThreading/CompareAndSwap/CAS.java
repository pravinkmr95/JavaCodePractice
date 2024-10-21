package MultiThreading.CompareAndSwap;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
    private int number;
    private AtomicInteger number1 = new AtomicInteger(0);

    public synchronized void increment() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }
        number++;
    }

    public void increment1(){
        number1.incrementAndGet();
        //System.out.println(number1);
    }

    public int getNumber(){
        return this.number;
    }

    public int getNumber1(){
        return this.number1.get();
    }
}
