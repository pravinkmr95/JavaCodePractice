package InterfacePractice;

import java.util.Collections;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main implements DefaultInInterface {
    Bird bird = new Bird() {
        @Override
        public void getInfo() {

        }

        @Override
        public void fly() {

        }

        @Override
        public void foo(){}
    };

    public int getData(){
        return 20;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.getValue());

        DefaultInInterface.print();

        FunctionalInterfaceTest obj1 = () -> {
            System.out.println("Test");
        };

        Being beingObj = (String name) -> {
            System.out.println(name + " passed");
            return true;
        };

        beingObj.canBreath("Lion");


        Consumer<String> consumer = (String val) -> {
            if (val.equals("accept")){
                System.out.println("Consumer functional interface with value " + val);
            }
        };
        consumer.accept("accept");
        consumer.accept("don't");

        int min_number = 10, max_number = 20;
        Supplier<Integer> supplier = () -> min_number + (int) (Math.random() * (max_number - min_number+1));
        System.out.println("Random number between " + min_number + " and " + max_number + " :" + supplier.get());
        System.out.println("Random number between " + min_number + " and " + max_number + " :" + supplier.get());

        Function<Integer, String> function = (Integer number) -> {
            number *= 2;
            return number.toString();
        };

        System.out.println(function.apply(10));
        System.out.println(function.apply(15));

        Predicate<Integer> predicate = (Integer number) -> number % 2 == 0;

        System.out.println(predicate.test(11));
        System.out.println(predicate.test(100));

//        Runnable task = () -> System.out.println("Task running in a thread");
//        new Thread(task).start();

        Predicate<String> startsWithA = s -> s.startsWith("A");
        startsWithA.test("ABCpdf");
        startsWithA.test("bbcgcf");
    }

}
