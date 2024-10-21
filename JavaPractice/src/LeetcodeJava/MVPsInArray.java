package LeetcodeJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MVPsInArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arr = {16,17,4,3,5,2};
        int size = arr.length;
        arrayList.add(arr[size-1]);
        int maxFromRight=arr[size-1];
        for (int i=size-2; i>=0; i--){
            if (arr[i] >= maxFromRight){
                arrayList.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }
}
