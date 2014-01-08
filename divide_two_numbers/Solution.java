package divide_two_numbers;
/*
 * Divide two integers without using multiplication, division and mod operator.
 */
public class Solution {
	public int divide(int dividend, int divisor) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        long res = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        while(a>=b){
            long c = b;
            for(int i = 0; a>=c; c<<=1, ++i){
                a-=c;
                res+=1<<i;
            }
        }
        return ((dividend^divisor)>>31)==0 ? (int)res : (int)(-res);
    }
}
