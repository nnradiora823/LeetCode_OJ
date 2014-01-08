package longest_substring_without_repeating_characters;
/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
	public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s==null || s.length()==0)
            return 0;
        int n = s.length();
        boolean[] table = new boolean[256];
        int last = 0, index = 0, maxLen = 0;
        while(index<n){
            char c = s.charAt(index);
            if(table[c]){
                maxLen = Math.max(maxLen, index-last);
                while(s.charAt(last) != c){
                    table[s.charAt(last)] = false;
                    last++;
                }
                last++;
                index++;
            }
            else{
                table[c] = true;
                index++;
                maxLen = Math.max(maxLen, index-last);
            }
        }
        return maxLen;
    }
}
