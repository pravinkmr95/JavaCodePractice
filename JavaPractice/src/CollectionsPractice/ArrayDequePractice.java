package CollectionsPractice;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.*;

public class ArrayDequePractice {
    public static void main(String[] args) {
        System.out.println("..........Stack using deque........");
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(0);
        stack.push(3);

        while (!stack.isEmpty())
            System.out.println(stack.pollFirst());

        System.out.println(stack.pollFirst());
        System.out.println("..........Queue using deque........");
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("10");
        queue.offer("20");
        queue.offer("Ac");
        queue.offer("BC");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
