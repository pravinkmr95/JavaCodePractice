package LeetcodeJava;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //System.out.println(Arrays.deepToString(intervals));
        int result = 0;
        int minEnd=intervals[0][1];
        //System.out.println(minEnd);
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] < minEnd){
                result++;
                minEnd = Math.min(minEnd, intervals[i][1]);
            } else {
                minEnd = intervals[i][1];
            }
            //System.out.println(minEnd + " Min end");
            //minEnd = Math.min(minEnd, intervals[i][1]);

        }
        return result;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals));

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals2));

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals3));

        int[][] intervals4 = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        System.out.println(nonOverlappingIntervals.eraseOverlapIntervals(intervals4));
    }
}
