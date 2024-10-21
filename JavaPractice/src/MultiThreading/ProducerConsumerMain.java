package MultiThreading;


import java.util.Scanner;

public class ProducerConsumerMain {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerResource producerConsumerResource = new ProducerConsumerResource(5);
        Scanner scanner = new Scanner(System.in);
        Thread producerThread = new Thread(() -> {
            //int number;
            //System.out.println("Producer thread");
            for (int i=0; i < 15; i++){
                // System.out.println("Enter the number to be pushed to the queue:");
                //number = scanner.nextInt();
                producerConsumerResource.pushNumber(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            //System.out.println("Consumer thread");
            for (int i=0; i<10; i++){
                producerConsumerResource.popNumber();
            }
//            String command = "continue";
//            while (!Objects.equals(command, "stop")){
//                producerConsumerResource.popNumber();
//                System.out.println("Enter continue/stop");
//                command = scanner.nextLine();
//            }
        });
        consumerThread.setPriority(10);
        consumerThread.setDaemon(true);
        producerThread.setPriority(Thread.NORM_PRIORITY);
        consumerThread.start();
        producerThread.start();
//        producerThread.join();
//        consumerThread.join();
        System.out.println("Main thread finished");
        //consumerThread.start();
    }
}
