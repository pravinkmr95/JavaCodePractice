package LeetcodeJava;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int maxEndingHere = 1;
        int minEndingHere = 1;
        int maxSoFar=Integer.MIN_VALUE;
        for (int num: nums){
            int temp1 = Math.max(num, Math.max(maxEndingHere*num, minEndingHere*num));
            int temp2 = Math.min(num, Math.min(maxEndingHere*num, minEndingHere*num));
            maxEndingHere = temp1;
            minEndingHere = temp2;
            if (maxEndingHere > maxSoFar){
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};

        MaximumProductSubArray obj = new MaximumProductSubArray();
        System.out.println(obj.maxProduct(arr));

        int[] arr1 = {-2,0,-1};
        System.out.println(obj.maxProduct(arr1));
    }
}
