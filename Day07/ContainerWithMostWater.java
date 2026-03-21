/*
Problem: Container With Most Water
Platform: LeetCode
Topic: Two Pointers / Greedy

Approach:
Use two pointers, one at the beginning and one at the end of the array.
Calculate the area, update the max area, and move the pointer pointing to the shorter line inward.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        
        while (l < r) {
            int currentArea = Math.min(height[l], height[r]) * (r - l);
            if (currentArea > max) max = currentArea;
            
            if (height[l] < height[r]) l++;
            else r--;
        }
        
        return max;
    }
}
