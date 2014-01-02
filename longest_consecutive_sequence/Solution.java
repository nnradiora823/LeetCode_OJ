package longest_consecutive_sequence;

import java.util.HashMap;

public class Solution {
	public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length<2)
            return num.length;
        int maxLen = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : num){
            if(map.containsKey(i))
                continue;
            map.put(i,1);
            if(map.containsKey(i-1)){
                maxLen = Math.max(maxLen, merge(map, i-1, i));
            }
            if(map.containsKey(i+1)){
                maxLen = Math.max(maxLen, merge(map, i, i+1));
            }
        }
        return maxLen;
    }
    
    public int merge(HashMap<Integer, Integer> map, int left, int right){
        int upper = right+map.get(right)-1;
        int lower = left-map.get(left)+1;
        int len = upper-lower+1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
}
