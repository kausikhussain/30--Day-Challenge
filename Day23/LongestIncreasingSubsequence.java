/*
Problem: Longest Increasing Subsequence
Platform: LeetCode
Topic: Array / Dynamic Programming / Binary Search

Approach:
Dynamic Programming approach. For each element at index i, check all previous 
elements before i. If an element before i is less than nums[i], we can extend 
the subsequence ending at that element. Take the maximum.
Note: An O(N log N) solution exists using Binary Search and Tails array.

Time Complexity: O(N^2) using standard DP.
Space Complexity: O(N)
*/

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is an increasing subsequence of length 1 by itself
        
        int maxLIS = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}
