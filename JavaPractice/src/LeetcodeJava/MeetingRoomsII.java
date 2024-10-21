package LeetcodeJava;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals){
        int[] arr = new int[intervals.length];
        int[] dep = new int[intervals.length];
        for (int i=0; i<intervals.length; i++){
            arr[i] = intervals[i][0];
            dep[i] = intervals[i][1];
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int numberOfRooms=1;
        int maxRooms = 1;
        int arrIterator=1;
        int depIterator=0;
        while (arrIterator < intervals.length){
            if (arr[arrIterator] <= dep[depIterator]){
                numberOfRooms++;
                maxRooms = Math.max(maxRooms, numberOfRooms);
                arrIterator++;
            } else {
                depIterator++;
                numberOfRooms--;
            }
        }
        return maxRooms;
    }

    public int meetingRooms(int[][] intervals){
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] interval: intervals){
            if (!heap.isEmpty() && heap.peek() < interval[0]){
                heap.poll();
            }
            heap.offer(interval[1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();

        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingRoomsII.minMeetingRooms(intervals1));// Output: 2
        System.out.println(meetingRoomsII.meetingRooms(intervals1));

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(meetingRoomsII.minMeetingRooms(intervals2));
        System.out.println(meetingRoomsII.meetingRooms(intervals2));
    }
}
