package multiply_strings;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
 */

public class Solution {
	public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0)
            return "0";
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1+len2];
        for(int i = 0; i<len1; i++){
            int carry = 0;
            int a = num1.charAt(len1-i-1)-'0';
            for(int j = 0; j<len2; j++){
                int b = num2.charAt(len2-j-1)-'0';
                res[i+j] += (carry+a*b);
                carry = res[i+j]/10;
                res[i+j] = res[i+j]%10;
            }
            res[i+len2] += carry;
        }
        int index = len1+len2-1;
        while(res[index]==0)
            index--;
        if(index>=0){
            StringBuffer sb =new StringBuffer();
            while(index>=0){
                sb.append(res[index]);
                index--;
            }
            return sb.toString();
        }
        return "0";
    }
}
