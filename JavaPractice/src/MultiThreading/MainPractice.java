package MultiThreading;

public class MainPractice {
    public static void main(String[] args) {
        SharedResourcePractice sharedResource = new SharedResourcePractice();
        Thread producerThread = new Thread(() -> {
            try{
                Thread.sleep(10000);
                sharedResource.producer();
            } catch (Exception e){
                //
            }
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer");
            sharedResource.consumer();
        });

        producerThread.start();
        consumerThread.start();
    }
}
