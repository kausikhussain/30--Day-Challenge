/*
Problem: Counting Bits
Platform: LeetCode
Topic: Bit Manipulation / Dynamic Programming

Approach:
Use DP. The number of set bits in a number 'i' is equal to the number of set bits
in its half (i >> 1) plus 1 if 'i' is odd. 
Base case: dp[0] = 0.
dp[i] = dp[i >> 1] + (i & 1).

Time Complexity: O(n)
Space Complexity: O(n) for the output array
*/

class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        
        return dp;
    }
}
