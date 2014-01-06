package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
 */
public class Solution {
	public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> res = new ArrayList<String>();
        if(strs==null || strs.length==0)
            return null;
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if(map.containsKey(key)){
                ArrayList<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
            else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }        
        for(String key : map.keySet()){
            if(map.get(key).size()>1){
                res.addAll(map.get(key));
            }
        }
        return res;
    }
}
