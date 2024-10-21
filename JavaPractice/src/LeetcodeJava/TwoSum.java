package LeetcodeJava;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i=0; i < nums.length; i++){
            int num = nums[i];
            if (hash.containsKey(target - num)){
                return new int[]{hash.get(target - num), i};
            }
            hash.put(num, i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum obj = new TwoSum();
        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }
}
