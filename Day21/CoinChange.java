/*
Problem: Coin Change
Platform: LeetCode
Topic: Dynamic Programming

Approach:
Use a bottom-up DP array where dp[i] represents the minimum number of coins
needed to make amount i. Initialize array with amount + 1. DP state transitions:
dp[i] = min(dp[i], 1 + dp[i - coin]) for all valid coins.

Time Complexity: O(amount * len(coins))
Space Complexity: O(amount)
*/

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
