package interleaving_string;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1==null || s2==null || s3==null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3)
            return false;
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i = 0; i<len1; i++){
            if(s1.charAt(i)==s3.charAt(i)){
                dp[i+1][0] = true;
            }
        }
        
        for(int i = 0; i<len2; i++){
            if(s2.charAt(i)==s3.charAt(i)){
                dp[0][i+1] = true;
            }
        }
        
        for(int i = 1; i<=len1; i++){
            for(int j = 1; j<=len2; j++){
                //start from s2
                if(dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                //start from s1
                else if(dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j] = true;
                }
                else
                    dp[i][j] = false;
            }
        }
        return dp[len1][len2];
    }
    
    
    //with one dimmension buffer 
    public boolean isInterleave2(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3)
            return false;
        boolean[] dp = new boolean[len2+1];
        dp[0] = true;
        for(int i = 1; i<=len2; i++){
            dp[i] = s2.substring(0,i).equals(s3.substring(0,i));
        }
        
        for(int i = 1; i<=len1; i++){
            dp[0] = s1.substring(0,i).equals(s3.substring(0,i));
            for(int j = 1; j<=len2; j++){
                if(dp[j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[j] = true;
                }
                else if(dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[j] = true;
                } 
                else
                    dp[j] = false;
            }
        }
        return dp[len2];
    }
}
