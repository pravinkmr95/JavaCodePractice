package Annotations;

import java.util.ArrayList;
import java.util.List;

public class HeapPollution {

    public static void addString(List list, Object object){
        list.add(object);
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(100);
        System.out.println(arrayList);

        addString(arrayList, "abcd");

        for (Integer x: arrayList){
            System.out.println(x);
        }

        System.out.println(arrayList);

        List<Object> arrList = new ArrayList<>();
        arrList.add("abcd");
        arrList.add(10);
        System.out.println(arrList);
    }
}
