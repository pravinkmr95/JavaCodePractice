package MultiThreading;

import java.util.ArrayDeque;

public class ProducerConsumerResource {
    private ArrayDeque<Integer> queue = new ArrayDeque<>();
    private int maxQueueSize;

    ProducerConsumerResource(int queueSize){
        this.maxQueueSize = queueSize;
    }

    public synchronized void pushNumber(int number){
        System.out.println("Inside producer. Lock acquired");
        try{
            while (queue.size() == maxQueueSize){
                System.out.println("queue size reached max. Waiting the elements to be popped");
                wait();
            }
            System.out.println("Pushing number to queue: " + number);
            queue.offer(number);

            System.out.println("queue after pushing the number " + queue);
            notifyAll();
            //Thread.sleep(500);
        } catch (Exception e){
            //
        }

    }

    public synchronized void popNumber(){
        try {
            System.out.println("Inside consumer. Lock acquired");
            //Thread.sleep(10000);
            while (queue.isEmpty()){
                System.out.println("Queue is empty. Waiting for pushing the number");
                wait();
                //Thread.stop(); Throwing exception
                //Thread.suspend();
            }
            int number = queue.poll();
            System.out.println("number popped: " + number);
            notifyAll();
            //Thread.sleep(5000);
        } catch (Exception e){
            //
        }
    }
}
