package LeetcodeJava;

public class HouseRobberII {
    public int rob1(int[] nums, int start, int end){
        int rob1 = 0, rob2 = 0;
        for (int i=start; i<end; i++){
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length < 2){
            return nums[0];
        }
        int robWithoutFirst = rob1(nums, 1, nums.length);
        int robWithoutLast = rob1(nums, 0, nums.length-1);
        return Math.max(robWithoutFirst, robWithoutLast);
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int[] nums = {2,3,2};

        System.out.println(houseRobberII.rob(nums));

        int[] nums1 = {1,2,3,1};
        System.out.println(houseRobberII.rob(nums1));

        int[] nums2 = {1};
        System.out.println(houseRobberII.rob(nums2));

        int[] nums3 = {};
        System.out.println(houseRobberII.rob(nums3));

        int[] nums4 = {5, 4};
        System.out.println(houseRobberII.rob(nums4));
    }
}
