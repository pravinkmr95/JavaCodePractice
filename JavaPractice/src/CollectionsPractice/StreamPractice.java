package CollectionsPractice;

import InterfacePractice.A;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(65);
        linkedList.add(22);
        linkedList.add(44);
        linkedList.add(20);
        linkedList.add(20);
        Set<Integer> set = linkedList.stream().distinct().filter((num) -> num%2==0).map((num) -> num*10).sorted().collect(Collectors.toSet());
        System.out.println(set);
        List<Integer> list = linkedList.stream().distinct().filter((num) -> num%2==0).map((num) -> num*10).sorted().collect(Collectors.toList());
        System.out.println(list);
        //List<Integer> al = Arrays.asList(1, 2, 3, 45, 5);

        Stream<Integer> integerStream = Stream.of(10, 20, 30, 90, 0);
        //System.out.println();
        //Stream<Integer> newStream = integerStream.filter((n) -> n%2==0);
        List<String> stringList = integerStream.map((num) -> {
            String val = "String+" + String.valueOf(num);
            return val;
        }).toList();
        System.out.println(stringList);
        //newStream.forEach((x) -> System.out.println(x));
//        Arrays.stream()
        List<String> stringList1 = Arrays.asList("A", "B", "C", "D");
        System.out.println(stringList1.stream().max((a, b) -> b.compareTo(a)).get());
        //String concat = stringList1.stream().map((a) -> a.toLowerCase()).reduce((a, b) -> a + b).get();
        //System.out.println(concat);
        int[] arr = new int[5];
        arr[0]=0;
        arr[1] = 40;
        arr[2] = 11;
        arr[3] = 33;
        arr[4] = 90;
        //System.out.println(Arrays.stream(arr).max().getAsInt());
        //System.out.println(Arrays.stream(arr).noneMatch((a) -> a%2==1));//anyMatch->allMatch->noneMatch
        // System.out.println(Arrays.stream(arr).findFirst((a) -> ()); //findFirst((num) -> n>30)
        Stream<Integer> integerStream1 = Stream.of(10, 20, 30, 90, 0);
        //Optional<Integer> optional = integerStream1.filter((num) -> (num>20)).findFirst();
        Optional<Integer> optional = integerStream1.filter((num) -> (num>20)).findAny();
        System.out.println(optional.get());

        System.out.println(".............................");
        List<Integer> list1 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
        long t1 = System.currentTimeMillis();
        list1.stream().map((a) -> a*a).forEach((a) -> System.out.println(a));
        System.out.println("t1 time diff in ms->" + (System.currentTimeMillis() - t1));


        long t2 = System.currentTimeMillis();
        list1.parallelStream().map((a) -> a*a).forEach((a) -> System.out.println(a));
        System.out.println("t2 time diff in ms->" + (System.currentTimeMillis() - t2));

        System.out.println(".........Flat map............");
        List<String> stringList2 = Arrays.asList("hello", "world");
        System.out.println(stringList2.stream().map((str) -> str.length()).collect(Collectors.toList()));

        List<List<String>> stringList3 = Arrays.asList(
                Arrays.asList("hello"),
                Arrays.asList("world"),
                Arrays.asList("hey")
        );
        List<String> stringList4 = stringList3.stream().flatMap((a) -> a.stream()).collect(Collectors.toList());
        System.out.println(stringList4);

        System.out.println("....Stream max vs iterative max.....");

        int[] arr1 = new int[1000000];
        for (int i=0; i<1000000; i++){
            arr1[i] = i + (int) (100000 * Math.random());
        }
        long tt1 = System.currentTimeMillis();
        System.out.println(Arrays.stream(arr1).max().getAsInt());
        System.out.println("time diff: " + (System.currentTimeMillis() - tt1));

        long tt2 = System.currentTimeMillis();
        int max = Integer.MIN_VALUE;
        for (int num: arr1){
            if (num > max){
                max = num;
            }
        }
        System.out.println(max);
        System.out.println("time diff: " + (System.currentTimeMillis() - tt2));
    }
}
