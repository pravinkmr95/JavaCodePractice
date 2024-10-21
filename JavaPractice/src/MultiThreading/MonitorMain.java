package MultiThreading;

public class MonitorMain {
    public static void main(String[] args) {
        MonitorLocks monitorLocks = new MonitorLocks();
        Thread thread1 = new Thread(monitorLocks::method1);
        Thread thread2 = new Thread(() -> monitorLocks.method2());
        Thread thread3 = new Thread(() -> monitorLocks.method3());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
