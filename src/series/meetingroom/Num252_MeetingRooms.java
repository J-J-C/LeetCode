package series.meetingroom;

import java.util.Arrays;
import java.util.Comparator;

public class Num252_MeetingRooms {

  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }
}
