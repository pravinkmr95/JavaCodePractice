package LeetcodeJava;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int flag = nums.length-1;
        for (int i=nums.length-1; i>=0; i--){
            if ((nums[i] + i) >= flag){
                flag = i;
            }
        }
        return flag == 0;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGame.canJump(nums));

        int[] nums1 = {3,2,1,0,4};
        System.out.println(jumpGame.canJump(nums1));

        int[] nums2 = {3,2,2,0,4};
        System.out.println(jumpGame.canJump(nums2));
    }
}
