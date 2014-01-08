package container_with_most_water;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */

public class Solution {
	public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(height==null || height.length<2)
            return 0;
        int max = Integer.MIN_VALUE;
        int n = height.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int area = Math.min(height[left], height[right])*(right-left);
            max = Math.max(max, area);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
