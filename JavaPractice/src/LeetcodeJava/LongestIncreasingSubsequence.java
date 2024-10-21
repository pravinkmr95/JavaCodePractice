package LeetcodeJava;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i] && (dp[j] + 1) > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int maxCount = Integer.MIN_VALUE;
        for (int count: dp){
            if (count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(arr));

        int[] arr1 = {0,1,0,3,2,3};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(arr1));

        int[] arr2 = {7,7,7,7,7,7,7};
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(arr2));
    }
}
