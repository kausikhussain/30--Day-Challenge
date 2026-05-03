/*
Problem: Target Sum
Platform: LeetCode
Topic: Dynamic Programming / Backtracking

Approach:
This can be transformed into a subset sum problem. Let sum(P) be the elements with + 
and sum(N) be the elements with -.
We know: sum(P) - sum(N) = target and sum(P) + sum(N) = sum(nums)
=> 2 * sum(P) = target + sum(nums) => sum(P) = (target + sum(nums)) / 2
We just need to find the number of subsets that sum to (target + sum(nums)) / 2.
Use a 1D DP array to solve the subset sum problem.

Time Complexity: O(N * S) where N is the number of elements and S is the target sum.
Space Complexity: O(S)
*/

class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Check for invalid targets
        if (target > sum || target < -sum || (target + sum) % 2 != 0) {
            return 0;
        }
        
        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // 1 way to make sum 0 (choose nothing)
        
        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        
        return dp[subsetSum];
    }
}
