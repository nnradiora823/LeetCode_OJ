package pow;

/*
 * Implement pow(x, n).
 */

public class Solution {
	public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n==0)
            return 1.0;
        double half = pow(x,n/2);
        if(n%2==0)
            return half*half;
        else if(n>0){
            return half*half*x;
        }
        else
            return half*half/x;
    }
}
