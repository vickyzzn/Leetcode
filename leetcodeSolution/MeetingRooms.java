package leetcodeSolution;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:
        [[2,4], [7,10]]
Input: [[7,10],[2,4]]
Output: true

time: O(nlogn)
 */
public class MeetingRooms {
    public class Interval{
        int start;
        int end;
        Interval(){start = 0; end  = 0;}
        Interval(int s, int e){start = s; end = e;}
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null) return false;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

//        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end){
                return false;
            }
        }
        return true;
    }

    }
