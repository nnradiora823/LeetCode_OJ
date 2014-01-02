package word_ladder;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * 
 */

import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(start==null || end==null || dict==null || dict.size()==0)
            return 0;
        if(start.length()==0 && end.length()==0)
            return 0;
        int count = 0;
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(start);
        dict.add(end);
        visited.add(start);
        int curLevel = 1, nextLevel = 0;
        while(!queue.isEmpty()){
            String word = queue.pollFirst();
            curLevel--;
            if(word.equals(end)){
                return count+1;
            }
            else{
                for(int i = 0; i<word.length(); i++){
                    for(int j = 'a'; j<'z'; j++){
                        char[] array = word.toCharArray();
                        if(array[i]!=j){
                            array[i] = (char)j;
                            String newWord = new String(array);
                            if((dict.contains(newWord) && !visited.contains(newWord))){
                                queue.add(newWord);
                                visited.add(newWord);
                                nextLevel++;
                           }
                       }
                    }
                }
            }
            if(curLevel==0){
                curLevel = nextLevel;
                count++;
                nextLevel = 0;
            }
            
        }
        return 0;
    }
}
