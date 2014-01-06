package insert_interval;

import java.util.ArrayList;

import datastructure.Interval;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> res = new ArrayList<Interval>();
        if(intervals==null || intervals.isEmpty()){
            res.add(newInterval);
            return res;
        }
        
        int index = 0;
        int size = intervals.size();
        while(index<size && intervals.get(index).end < newInterval.start){
            res.add(intervals.get(index));
            index++;
        }
        
        while(index<size && newInterval.end >= intervals.get(index).start){
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index++;
        }
        
        res.add(newInterval);
        while(index<size){
            res.add(intervals.get(index));
            index++;
        }
        return res;
    }
}
