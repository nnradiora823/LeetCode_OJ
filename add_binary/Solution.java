package add_binary;

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */

public class Solution {
	public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a==null || b==null || a.length()==0 || b.length()==0)
            return null;
        int carry = 0;
        int i = a.length()-1, j = b.length()-1;
        StringBuffer sb = new StringBuffer();
        while(i>=0 || j>=0 || carry>0){
            int sum = (i>=0?a.charAt(i)-'0':0)+(j>=0?b.charAt(j)-'0':0)+carry;
            sb.insert(0, String.valueOf(sum%2));
            carry = sum/2;
            i--;
            j--;
        }
        return sb.toString();
    }
}
