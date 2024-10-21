package MultiThreading;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantMain {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        ReentrantResource reentrantResource1 = new ReentrantResource();
        ReentrantResource reentrantResource2 = new ReentrantResource();

        Thread thread1 = new Thread(() -> reentrantResource1.producer(lock));
        Thread thread2 = new Thread(() -> reentrantResource2.producer(lock));

        thread1.start();
        thread2.start();
//        int[] arr = new int[5];
//        HashSet<Integer> hashSet = new HashSet<>();
        int x = Integer.MAX_VALUE;
    }
}
