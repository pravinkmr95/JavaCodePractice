package LeetcodeJava;

public class FindMinimumInRotatedSortedArray {
    public int findPivotIndex(int[] arr, int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            if (mid > left && arr[mid] < arr[mid-1]){
                return mid;
            } else if (mid < right && arr[mid] > arr[mid+1]){
                return mid+1;
            } else if (arr[mid] >= arr[0]){
                return findPivotIndex(arr, mid+1, right);
            } else {
                return findPivotIndex(arr, left, mid-1);
            }
        }
        return -1;
    }
    public int findMin(int[] nums) {
        int pivotIndex = findPivotIndex(nums, 0, nums.length-1);
        if (pivotIndex != -1){
            return nums[pivotIndex];
        } else {
            return nums[0];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        System.out.println(obj.findMin(arr));

        int[] arr1 = {4,5,6,7,0,1,2};
        System.out.println(obj.findMin(arr1));

        int[] arr2 = {11,13,15,17};
        System.out.println(obj.findMin(arr2));
    }
}
