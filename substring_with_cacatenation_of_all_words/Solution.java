package substring_with_cacatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(S==null || S.length()==0 || L==null || L.length==0){
            return res;
        }
        int m = S.length();
        int count = L.length;
        int len = L[0].length();
        if(m<count*len)
            return res;
        String[] indexes = new String[m];
        Map<String, Integer> lookUp = new HashMap<String, Integer>();
        for(int i = 0; i<count; i++){
            String key = L[i];
            if(lookUp.containsKey(key)){
                lookUp.put(key, lookUp.get(key)+1);
            }
            else{
                lookUp.put(key,1);
            }
        }
        for(int i = 0; i<m-len+1; i++){
            String key = S.substring(i, i+len);
            if(lookUp.containsKey(key)){
                indexes[i] = key;
            }
            else
                indexes[i] = null;
        }
        
        for(int i = 0; i<m-count*len+1; i++){
            int right = i;
            int myCount = 0;
            while(right<m && indexes[right]!=null && lookUp.get(indexes[right])>0){
                myCount++;
                String key = indexes[right];
                lookUp.put(key, lookUp.get(key)-1);
                right = right+len;
            }
            if(myCount==count)
                res.add(i);
            recover(lookUp, L);
        }
        return res;    
    }
    
    public void recover(Map<String, Integer> lookUp, String[] L){
        lookUp.clear();
        for(int i = 0; i<L.length; i++){
            String key = L[i];
            if(lookUp.containsKey(key)){
                lookUp.put(key, lookUp.get(key)+1);
            }
            else{
                lookUp.put(key,1);
            }
        }
    }
}
