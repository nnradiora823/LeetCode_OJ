package word_break;

import java.util.Set;

/*
 * 
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(s==null || s.length()==0 || dict.isEmpty())
            return false;
        if(dict.contains(s))
            return true;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i<=n; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[n];
    }
}
