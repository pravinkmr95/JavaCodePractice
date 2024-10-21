package MultiThreading.CompareAndSwap;

public class CASMain {
    public static void main(String[] args) throws InterruptedException {
        CAS cas = new CAS();
        for (int i=0; i<400; i++){
            cas.increment();
        }
        System.out.println(cas.getNumber());
        CAS cas1 = new CAS();
        Thread thread1 = new Thread(() -> {
            for (int i=0; i<200; i++){
                cas1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0; i<200; i++){
                cas1.increment();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println(cas1.getNumber());

        CAS cas2 = new CAS();
        Thread thread3 = new Thread(() -> {
            for (int i=0; i < 200; i++){
                cas2.increment1();
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i=0; i < 200; i++){
                cas2.increment1();
            }
        });

        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
        }
        System.out.println(cas2.getNumber1());
    }
}
