package MultiThreading;

public class MultiThreading {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().threadId();
        System.out.println(name);
        System.out.println(id);
    }
}
