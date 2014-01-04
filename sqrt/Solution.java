package sqrt;
/*
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */

/*
 * Let the given number be b and let x be a rough guess of the square root of b. Newton's method suggests that a better guess, New x can be computed as follows:
	new x = 1/2(x+b/x)
 */
public class Solution {
	public int sqrt(int x){
        double x1 = x;
        double x2= x-0.1;
        double delta = 0.0001;
        while(Math.abs(x2-x1)>delta){
            x1 = x2;
            x2 = x1/2+x/(2*x1);
        }
        return (int)x2;
    }
}
