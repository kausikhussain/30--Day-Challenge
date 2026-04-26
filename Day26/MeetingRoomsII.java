/*
Problem: Meeting Rooms II
Platform: LeetCode
Topic: Array / Intervals / Heap

Approach:
Separate start times and end times into two arrays and sort them independently.
Use two pointers (one for start times, one for end times) to iterate.
If start time < end time, we need a new room, increment room count.
If start time >= end time, a meeting finished, so we don't need a new room (move end pointer).

Time Complexity: O(N log N)
Space Complexity: O(N)
*/

import java.util.Arrays;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endPtr = 0;
        
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endPtr]) {
                rooms++; // Need a new room
            } else {
                endPtr++; // A room freed up, reuse it
            }
        }
        
        return rooms;
    }
}
