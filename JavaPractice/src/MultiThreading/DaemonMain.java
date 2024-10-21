package MultiThreading;

public class DaemonMain {
    public static void main(String[] args) {
        DaemonThread daemonThreadObj = new DaemonThread();
        Thread daemonThread = new Thread(() -> {
            System.out.println("Inside daemon thread. It should wait for 10 sec if not daemon");
            daemonThreadObj.producer();
        });
         daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("Main thread closing");
    }
}
