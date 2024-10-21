package LeetcodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public void backTrack(int[] candidates, List<List<Integer>> output, List<Integer> tempList, int remaining, int start){
        if (remaining == 0){
            output.add(new ArrayList<>(tempList));
            return;
        }
        if (remaining < 0){
            return;
        }
        for (int i=start; i<candidates.length; i++){
            tempList.add(candidates[i]);
            backTrack(candidates, output, tempList, remaining-candidates[i], i);
            tempList.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(candidates, result, tempList, target, 0);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(obj.combinationSum(candidates1, target1));
    }
}
