package CollectionsPractice;

import GenericClasses.Pair;

import java.util.*;

public class Iterable {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Stack<Integer> stack = new Stack<>();
        stack.addAll(arrayList);
        System.out.println(stack.containsAll(arrayList));
        arrayList.remove(Integer.valueOf(3));
        System.out.println(arrayList + " " + stack);
        System.out.println(stack.containsAll(arrayList));
        System.out.println(arrayList.containsAll(stack));

        System.out.println(arrayList);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            int value = iterator.next();
            if (value == 5){
                iterator.remove();
            }
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println(arrayList);

        for (int n : arrayList){
            System.out.print(n + " ");
        }
        System.out.println();

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(0);
        set.add(null);

//        set.addAll(arrayList);
//
//        System.out.println("After using addAll into set " + set);
//        arrayList.addAll(set);
//        System.out.println("After using addAll into arraylist " + arrayList);// throwing exception because arrayList
//        doesn't accept null value similar to set.
        for (Integer val: set){
            System.out.println(val);
        }

        List<Integer> integerList = new LinkedList<>();
        arrayList.forEach((a) -> {
            System.out.println("Adding square for number to the list: " + a);
            integerList.add(a*a);
        });
        System.out.println(integerList);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(10, 20);
        hashMap.put(30, 40);
        hashMap.put(40, 50);
        hashMap.put(10, 30);
        System.out.println(hashMap);
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        hashMap.forEach((key, value) -> {
            pairList.add(new Pair<>(key, value));
        });
        System.out.println(pairList);

        arrayList.clear();
        System.out.println(arrayList);

    }
}
