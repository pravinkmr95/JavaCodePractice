package LeetcodeJava;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int num: nums){
            xor ^= num;
        }
        for(int i=0; i<=nums.length; i++){
            xor ^= i;
        }
        return xor;
    }
    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(obj.missingNumber(nums));

        int[] nums1 = {0, 1};
        System.out.println(obj.missingNumber(nums1));
    }
}
