package LeetcodeJava;

import java.util.Arrays;

public class CountingBits {
    public int numberOf1s(int n){
        int res = 0;
        while (n !=0){
            n -= n&-n;
            res++;
        }
        return res;
    }

    public int[] countBits(int n) {
        int[] output = new int[n+1];
        for (int i=0; i<=n; i++){
            output[i] = numberOf1s(i);
        }
        return output;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        int n=2;
        System.out.println(Arrays.toString(obj.countBits(n)));
    }
}
