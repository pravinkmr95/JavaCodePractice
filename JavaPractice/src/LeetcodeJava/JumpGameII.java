package LeetcodeJava;

public class JumpGameII {
    public int jump(int[] nums) {
        int start=0, end=0;
        int n = nums.length;
        int result=0;
        while (end < n-1){
            int farthest = 0;
            for (int i=start; i<=end; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            start = end+1;
            end = farthest;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGameII.jump(nums));
    }
}
