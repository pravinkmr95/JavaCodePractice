package LeetcodeJava;


public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int output = 0;
        while (left < right){
            int water = Math.min(height[left], height[right]) * (right-left);
            output = Math.max(output, water);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] arr ={1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(arr));
    }
}
