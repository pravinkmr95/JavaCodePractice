package LeetcodeJava;


public class SearchInSortedRotatedArray {
    public int findPivotIndex(int[] arr, int left, int right){
        if (left <= right){
            int mid = (left + right)/2;
            if (mid > left && arr[mid] < arr[mid-1]){
                return mid;
            } else if(mid < right && arr[mid] > arr[mid+1]){
                return mid+1;
            } else if (arr[mid] >= arr[0]){
                return findPivotIndex(arr, mid+1, right);
            } else {
                return findPivotIndex(arr, left, mid-1);
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int left, int right, int target){
        if (left <= right){
            int mid = (left + right)/2;
            if (arr[mid] == target){
                return mid;
            } else if(target > arr[mid]){
                return binarySearch(arr, mid+1, right, target);
            } else {
                return binarySearch(arr, left, mid-1, target);
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums, 0, nums.length-1);
        //System.out.println("Pivot index== " + pivotIndex);

        if (pivotIndex == -1){
            return binarySearch(nums, 0, nums.length-1, target);
        } else if (target == nums[pivotIndex]){
                return pivotIndex;
        } else {
            if (target >= nums[0]){
                return binarySearch(nums, 0, pivotIndex-1, target);
            } else{
                return binarySearch(nums, pivotIndex+1, nums.length-1, target);
            }
        }

    }

    public static void main(String[] args) {
        SearchInSortedRotatedArray obj = new SearchInSortedRotatedArray();
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(obj.search(arr, target));

        int[] arr1 = {4,5,6,7,0,1,2};
        int target1 = 3;
        System.out.println(obj.search(arr1, target1));

        int[] arr2 = {1};
        int target2 = 0;
        System.out.println(obj.search(arr2, target2));

        int[] arr3 = {1};
        int target3 = 1;
        System.out.println(obj.search(arr3, target3));

        int[] arr4 = {3, 1};
        int target4 = 3;
        System.out.println(obj.search(arr4, target4));
    }
}
