package LeetcodeJava;

import java.util.Arrays;

public class MeetingRoomsI {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRoomsI meetingRoomsI = new MeetingRoomsI();
        int[][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingRoomsI.canAttendMeetings(intervals1));
        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(meetingRoomsI.canAttendMeetings(intervals2));

    }
}
