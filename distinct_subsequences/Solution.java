package distinct_subsequences;
/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
 */
public class Solution {
	public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(S!=null && T==null)
            return 0;
        int n = S.length();
        int m = T.length();
        if(n<m)
            return 0;
        int[] table = new int[m+1];
        table[m] = 1;
        for(int i = n-1;i>=0;i--){
            for(int j = 0; j<m; j++){
                if(S.charAt(i)==T.charAt(j)){
                    table[j] = table[j]+table[j+1];
                }
                else{
                    table[j] = table[j];
                }
            }
        }
        return table[0];
    }
}
