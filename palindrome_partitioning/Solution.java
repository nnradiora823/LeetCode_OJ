package palindrome_partitioning;
/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s==null || s.length()==0)
            return new ArrayList<ArrayList<String>>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for(int i = 1; i<n; i++){
            dp[i][i] = true;
        }
        
        for(int i = 0; i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
            }
            else{
                dp[i][i+1] = false;
            }
        }
        
        for(int len=3; len<=n; len++){
            for(int i = 0; i<n-len+1; i++){
                int j = i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }
        
        return partitionHelper(dp, 0, s);
    }
    
    public ArrayList<ArrayList<String>> partitionHelper(boolean[][] dp, int start, String s){
        ArrayList<ArrayList<String>> allPartitions = new ArrayList<ArrayList<String>>();
        if(start == s.length()){
            allPartitions.add(new ArrayList<String>());
            return allPartitions;
        }
        for(int i = start; i<s.length();i++){
            if(dp[start][i]){
                for(ArrayList<String> partition: partitionHelper(dp, i+1, s)){
                    partition.add(0, s.substring(start,i+1));
                    allPartitions.add(partition);
                }
            }
        }
        return allPartitions;
    }
    
}