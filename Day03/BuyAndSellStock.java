/*
Problem: Best Time to Buy and Sell Stock
Platform: LeetCode
Topic: Sliding Window

Approach:
Keep track of min price seen so far.
Update max profit if current price - min price > max profit.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else if (p - minPrice > maxProfit) maxProfit = p - minPrice;
        }
        
        return maxProfit;
    }
}
