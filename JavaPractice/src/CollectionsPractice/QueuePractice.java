package CollectionsPractice;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePractice {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b-a)); //Max Priority queue
        System.out.println(queue.add(5));
        queue.offer(2);
//        queue.offer(1);
//        queue.add(10);
//        queue.offer(20);
        queue.add(8);
        queue.offer(1);
        System.out.println("top is " + queue.peek());
        System.out.println(queue);
//        Integer x = queue.poll();
//        System.out.println(x);
//        x = queue.poll();
//        System.out.println(x);
//        x = queue.poll();
//        System.out.println(x);
//        x = queue.poll();
//        System.out.println(x);
//
//        x = queue.poll();
//        System.out.println(x);
//        System.out.println(queue);
//        int counter = 0;
        queue.forEach((number) -> {
            System.out.println("for each " + number);
        });

        while (!queue.isEmpty()){
            System.out.println("Using Poll: " + queue.poll());
        }
    }
}
