package leetcodeSolution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 */
public class MeetingRoom2 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }else{
                    return o1.start - o2.start;
                }
            }
        });

        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        pq.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= pq.peek().end){
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval r = new Interval(7, 10);
        Interval s = new Interval(2, 4);
        MeetingRoom2 res = new MeetingRoom2();
        Interval[] intervals = {r, s};
        System.out.println(res.minMeetingRooms(intervals));
    }


}
