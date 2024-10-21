import java.util.ArrayDeque;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(intervals[0]);
        for (int i=1; i < intervals.length; i++){
            int[] interval = intervals[i];
            int[] lastInterval = stack.peek();
            if (interval[0] <= lastInterval[1]){
                lastInterval[1] = Math.max(interval[1], lastInterval[1]);
            } else {
                stack.push(intervals[i]);
            }
        }
        int[][] output = new int[stack.size()][];
        int k = 0;
        for (int[] interval: stack){
            output[k++] = interval;
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        System.out.println(Arrays.deepToString(obj.merge(intervals)));
    }
}
