/*
Problem: Best Time to Buy and Sell Stock with Cooldown
Platform: LeetCode
Topic: Dynamic Programming / State Machine

Approach:
Maintain three states:
- s0: rest state before buying, or resting after cooldown
- s1: state after buying (holding stock)
- s2: state after selling (must rest next day)
Transitions:
s0[i] = max(s0[i-1], s2[i-1])
s1[i] = max(s1[i-1], s0[i-1] - prices[i])
s2[i] = s1[i-1] + prices[i]

Time Complexity: O(N)
Space Complexity: O(1) by optimizing space to only previous states
*/

class StockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int s0 = 0;
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        
        for (int i = 1; i < prices.length; i++) {
            int pre_s0 = s0;
            int pre_s1 = s1;
            int pre_s2 = s2;
            
            s0 = Math.max(pre_s0, pre_s2);
            s1 = Math.max(pre_s1, pre_s0 - prices[i]);
            s2 = pre_s1 + prices[i];
        }
        
        return Math.max(s0, s2);
    }
}
