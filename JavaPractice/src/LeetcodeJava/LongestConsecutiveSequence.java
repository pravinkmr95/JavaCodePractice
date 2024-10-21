package LeetcodeJava;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int number: nums){
            hashSet.add(number);
        }
        int maxCount = 0;
        for (int i=0; i<nums.length; i++){
            int number = nums[i];
            int currCount = 0;
            if (!hashSet.contains(number-1)){
                while (hashSet.contains(number+currCount)){
                    currCount++;
                }
                maxCount = Math.max(currCount, maxCount);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));

        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums1));
    }
}
