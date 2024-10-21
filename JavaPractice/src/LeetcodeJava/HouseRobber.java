package LeetcodeJava;

public class HouseRobber {
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int num: nums){
            int temp = Math.max(rob1+num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = {1,2,3,1};
        System.out.println(houseRobber.rob(nums));

        int[] nums1 = {2,7,9,3,1};
        System.out.println(houseRobber.rob(nums1));
    }
}
