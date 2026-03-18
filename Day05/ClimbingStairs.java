/*
Problem: Climbing Stairs
Platform: LeetCode
Topic: Dynamic Programming

Approach:
It's basically generating Fibonacci numbers since ways(n) = ways(n-1) + ways(n-2).
Use two variables to track the last two results instead of an array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev1 = 2; // ways to reach step 2
        int prev2 = 1; // ways to reach step 1
        
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}
