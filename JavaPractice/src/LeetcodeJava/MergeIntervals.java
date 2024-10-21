package LeetcodeJava;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> outputList = new ArrayList<>();
        int[] lastInterval = intervals[0];
        outputList.add(lastInterval);
        for (int[] interval: intervals){
            if (lastInterval[1] >= interval[0]){
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                lastInterval = interval;
                outputList.add(interval);
            }

        }
        return outputList.toArray(new int[outputList.size()][]);
    }




    public int[][] mergePractice(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> outputList = new ArrayList<>();
        int[] last = intervals[0];
        outputList.add(last);
        for (int i=1; i<intervals.length; i++){
            int[] currInterval = intervals[i];
            if (currInterval[0] <= last[1]){
                last[1] = Math.max(last[1], currInterval[1]);
            } else {
                outputList.add(currInterval);
                last = currInterval;
            }
        }
        return outputList.toArray(new int[outputList.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] intervals = {{2,6}, {1,3},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(mergeIntervals.merge(intervals)));
        System.out.println(Arrays.deepToString(mergeIntervals.mergePractice(intervals)));

        int[][] intervals1 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(mergeIntervals.merge(intervals1)));
        System.out.println(Arrays.deepToString(mergeIntervals.mergePractice(intervals1)));

        //Arrays.sort() does not directly support sorting primitive types like int[]
    }
}
