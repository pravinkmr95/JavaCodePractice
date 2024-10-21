package MultiThreading;

public class Main1 {
    public static void main(String[] args) {
        SharedResource1 sharedResource1 = new SharedResource1();
        SharedResource1 sharedResource2 = new SharedResource1();

        Thread thread1 = new Thread(() -> sharedResource1.produce());
        Thread thread2 = new Thread(sharedResource2::produce);

        thread1.start();
        thread2.start();
    }
}
