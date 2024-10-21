package CollectionsPractice;

import javax.swing.*;
import java.util.*;

public class ListPractice {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(0, 1);
        list1.add(1, 2);
        System.out.println(list1);
        System.out.println(list1.get(1));
        Collections.reverse(list1);
        System.out.println("Reversed list "+ list1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(40);
        list2.set(1, 10000);
        list2.add(1, 222);
        list2.remove(Integer.valueOf(222));
        list1.addAll(list2);
        list1.forEach((num) -> System.out.println("list1->" + num));
        list1.removeAll(list2);
        System.out.println(list1);
        list1.replaceAll((num) -> num*-1);
        System.out.println(list1);

        String str = "dfnlwnAbcdedfgd";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);
        System.out.println(str);
        String a=null;
        System.out.println(Integer.valueOf("12"));
        System.out.println(String.valueOf(122));

        System.out.println(list1);
        System.out.println(list1.indexOf(-1));
        int[] arr = new int[5];
        for (int i=0; i<5; i++){
            arr[i] = i + (int)(Math.random()*i);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.binarySearch(arr, 3));

        //LinkedList
        System.out.println("LinkedList");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addLast(100);
        linkedList.addFirst(200);
        System.out.println(linkedList);

        System.out.println(linkedList.get(3));
        linkedList.add(2, 132);
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf(132));
        linkedList.add(null);
        System.out.println(linkedList);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(0);
        System.out.println(pq);
        // pq.add(null);//null pointer exception
        // System.out.println(pq);

        System.out.println("Vector is same as ArrayList and it is thread safe..");
        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.addFirst(30);
        System.out.println(vector);
        vector.removeLast();
        System.out.println(vector);

        System.out.println("Stack is child of Vector and it is also thread safe");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(0);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        LinkedHashMap<Integer, String> linkedHashMapTest = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMapTest.put(1, "One");
        linkedHashMapTest.put(2, "two");
        linkedHashMapTest.put(3, "three");
        linkedHashMapTest.put(4, "four");
        linkedHashMapTest.put(5, "five");
        linkedHashMapTest.get(2);
        System.out.println(linkedHashMapTest);
        //can be used in LRU cache

    }
}
