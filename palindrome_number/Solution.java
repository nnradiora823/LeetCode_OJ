package palindrome_number;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */

public class Solution {
	public boolean isPalindrome(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(x<0)
            return false;
        int dividsor = 1;
        while(x/dividsor>=10){
            dividsor*=10;
        }
        
        while(x!=0){
            int front = x/dividsor;
            int back = x%10;
            if(front!=back)
                return false;
            x = (x%dividsor)/10;
            dividsor = dividsor/100;
        }
        return true;
    }
}
