package CollectionsPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtility {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(40);
        arrayList.add(1);
        arrayList.add(300);
        arrayList.add(0);
        arrayList.add(100);
        Collections.sort(arrayList);
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        System.out.println("Sorted ArrayList: " + arrayList);
        System.out.println(Collections.binarySearch(arrayList, 1));
    }
}
