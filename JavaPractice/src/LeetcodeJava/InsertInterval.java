package LeetcodeJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> outputArrayList = new ArrayList<>();
        int i=0;
        while (i<intervals.length && intervals[i][1] < newInterval[0]){
            outputArrayList.add(intervals[i]);
            i++;
        }

        while (i<intervals.length && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        outputArrayList.add(newInterval);
        while (i<intervals.length){
            outputArrayList.add(intervals[i]);
            i++;
        }
        return outputArrayList.toArray(new int[outputArrayList.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals =  {{1,3},{6,9}};
        int[] newInterval = {2, 5};
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(Arrays.deepToString(insertInterval.insert(intervals, newInterval)));

        int[][] intervals1 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1 = {4, 8};
        System.out.println(Arrays.deepToString(insertInterval.insert(intervals1, newInterval1)));
    }
}
