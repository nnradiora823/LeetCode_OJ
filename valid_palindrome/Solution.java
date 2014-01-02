package valid_palindrome;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Solution {
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()==0)
            return true;
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        while(i<j){
            if((array[i]>='0' && array[i]<='9') || (array[i]>='a' && array[i]<='z')){
                if((array[j]>='0' && array[j]<='9') || (array[j]>='a' && array[j]<='z')){
                    if(array[i]!=array[j])
                        return false;
                    else{
                        i++;
                        j--;
                    }
                }
                else if (!(array[j]>='0' && array[j]<='9') && !(array[j]>='a' && array[j]<='z'))
                    j--;
            }
            else{
                if(!(array[j]>='0' && array[j]<='9') && !(array[j]>='a' && array[j]<='z')){
                        i++;
                        j--;
                }
                else
                    i++;
            }
        }
        return true;
    }
}
