package LeetcodeJava;

public class MaximumSubArraySum {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int num: nums){
            maxEndingHere += num;
            if (maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubArraySum obj = new MaximumSubArraySum();
        System.out.println(obj.maxSubArray(arr));
    }
}
