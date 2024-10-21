package LeetcodeJava;

public class RemovingMaximumMinimumFromArray {
    public int minimumDeletions(int[] nums) {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] < nums[minIndex]){
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
//        System.out.println("MaxIndex = " + maxIndex);
//        System.out.println("MinIndex = " + minIndex);
        int costDeleteMin;
        if (minIndex > nums.length/2){
            costDeleteMin = nums.length - minIndex;
        } else {
            costDeleteMin = minIndex+1;
        }
        int costDeleteMax;
        if (maxIndex > nums.length/2){
            costDeleteMax = nums.length - maxIndex;
        } else {
            costDeleteMax = maxIndex+1;
        }
        //System.out.println(costDeleteMin + " -> " + costDeleteMax);
        int output = costDeleteMin + costDeleteMax;
        output = Math.min(output, Math.max(minIndex, maxIndex) + 1);
        output = Math.min(output, nums.length - Math.min(minIndex, maxIndex));
        return output;
    }

    public static void main(String[] args) {
        RemovingMaximumMinimumFromArray removingMaximumMinimumFromArray = new RemovingMaximumMinimumFromArray();
        int[] nums = {2,10,7,5,4,1,8,6};
        System.out.println(removingMaximumMinimumFromArray.minimumDeletions(nums));

        System.out.println(removingMaximumMinimumFromArray.minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5}));

        System.out.println(removingMaximumMinimumFromArray.minimumDeletions(new int[]{101}));

        System.out.println(removingMaximumMinimumFromArray.minimumDeletions(new int[]{-14,61,29,-18,59,13,-67,-16,55,-57,7,74}));
    }
}
