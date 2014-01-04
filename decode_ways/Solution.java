package decode_ways;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

public class Solution {
	public int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<=n; i++){
            int c1 = 0, c2 = 0;
            if(s.charAt(i-1)!='0')
                c1 = dp[i-1];
            if(i>=2 && (s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' && s.charAt(i-1)<='6')))
                c2 = dp[i-2];
            dp[i] = c1+c2;
        }
        return dp[n];
    }
}
