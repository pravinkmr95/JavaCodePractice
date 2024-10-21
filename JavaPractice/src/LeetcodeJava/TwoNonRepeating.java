package LeetcodeJava;

import java.util.Arrays;

public class TwoNonRepeating {
    public int[] singleNumber(int[] nums){
        int xor = 0;
        for (int num: nums){
            xor = xor^num;
        }
        int rmsb = (xor) & (-xor);
        int x=0, y=0;
        for (int num: nums){
            if ((rmsb & num) == 0){
                x = x^num;
            } else {
                y = y ^ num;
            }
        }
        return new int[] {x, y};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        int[] arr1 = {-1, 0};
        int[] arr2 = {0, 1};
        TwoNonRepeating obj = new TwoNonRepeating();
        System.out.println(Arrays.toString(obj.singleNumber(arr2)));
    }
}
