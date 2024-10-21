package MultiThreading;

public class SharedResourceUtil {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(() -> {
            try {
                System.out.println("producer sleeping");
                Thread.sleep(5000);
            } catch (Exception e) {
                //
            }
            sharedResource.produce();
        });
        Thread consumerThread = new Thread(sharedResource::consumerStock);
        producerThread.start();
        consumerThread.start();
    }
}
