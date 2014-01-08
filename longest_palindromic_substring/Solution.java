package longest_palindromic_substring;

/*
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
	public String longestPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		if(s==null)
            return null;
		char[] array = s.toCharArray();
        int n = s.length();
        int maxLen = 1;
        int beginIndex = 0;
        boolean[][] table = new boolean[1000][1000];
        for(int i = 0;i<n;i++){
            for(int j = 0; j<n ; j++){
                if(i==j){
                    table[i][j] = true;
                    continue;
                }
                table[i][j] = false;
            }
        }
        
        for(int i = 0;i<n-1;i++){
            if(array[i] == array[i+1]){
                table[i][i+1] = true;
                maxLen = 2;
                beginIndex = i;
            }
        }
        
        for(int len = 3; len<=n; len++){
            for(int i = 0; i<n-len+1; i++){
                int j = i+len-1;
                if(array[i]==array[j] && table[i+1][j-1]){
                    table[i][j] = true;
                    beginIndex = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(beginIndex, beginIndex+maxLen);
    }
}
