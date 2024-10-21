package LeetcodeJava;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }
        return nums.length != set.size();
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(arr));
    }
}
