package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import datastructure.Interval;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class Solution {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(intervals==null || intervals.isEmpty())
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval interval1, Interval interval2){
               Integer start1 = (Integer)interval1.start;
               Integer start2 = (Integer)interval2.start;
               return start1.compareTo(start2);
           }
        });
        
        ArrayList<Interval> res = new ArrayList<Interval>();
        res.add(intervals.get(0));
        for(int i = 1; i<intervals.size(); i++){
            Interval interval2 = intervals.get(i);
            Interval interval1 = res.get(res.size()-1);
            if(interval1.end<interval2.start){
                res.add(interval2);
            }
            else{
                interval1.start = Math.min(interval1.start, interval2.start);
                interval1.end = Math.max(interval1.end, interval2.end);
            }
        }
        return res;
    }
}
