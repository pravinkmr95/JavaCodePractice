package LeetcodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
    public List<List<Integer>> twoSum(int[] arr, int left, int right, int target){
        List<List<Integer>> twoSum = new ArrayList<>();
        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == target){
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(arr[left]);
                arrayList.add(arr[right]);
                twoSum.add(arrayList);
                left++;
                right--;
            } else if (target < sum) {
                right--;
            } else {
                left++;
            }
        }
        return twoSum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        List<List<Integer>> output = new ArrayList<>();
        for (int i=0; i < nums.length-3; i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> twoSumList = twoSum(nums, i+1, nums.length-1, -nums[i]);
            // System.out.println("twoSumList" + nums[i] + "  ->" +  twoSumList);
            if (!twoSumList.isEmpty()){
                for (List<Integer> twoSumData: twoSumList){
                    List<Integer> singleOutput = new ArrayList<>();
                    singleOutput.add(nums[i]);
                    singleOutput.addAll(twoSumData);
                    output.add(singleOutput);
                }
            }
        }
        return output;
    }

    public List<List<Integer>> threeSumOptimized(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();
        for (int i=0; i < arr.length-2; i++){
            if (i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arr.length-1;
            int target = -arr[i];
            while (left < right) {
//                if (left > 0 && arr[left] == arr[left-1]){
//                    continue;
//                }
                int sum = arr[left] + arr[right];
                //System.out.println(sum);
                if (sum == target) {
                    output.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left+1]){
                        left++;
                    }
                    while (left < right && arr[right] == arr[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (target < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ThreeSumProblem obj = new ThreeSumProblem();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> output = obj.threeSumOptimized(arr);
        System.out.println(output);

        int[] arr1 = {-2,0,0,2,2};
        System.out.println(obj.threeSumOptimized(arr1));
//        Arrays.sort(arr);
//        System.out.println(obj.twoSum(arr, 0, arr.length-1, 0));
//        System.out.println(Arrays.toString(arr));
//        List<List<Integer>> output = obj.twoSum(arr, 0, arr.length-1, 0);
//        System.out.println(output.size());
    }
}
