/*
Problem: Edit Distance
Platform: LeetCode
Topic: Dynamic Programming / String

Approach:
Use a 2D DP array. dp[i][j] represents the minimum operations to convert word1[0..i-1] 
to word2[0..j-1].
Base cases: converting an empty string to a string of length k takes k insertions (dp[0][k]=k).
If characters match: dp[i][j] = dp[i-1][j-1].
If they differ, take the min of insert, delete, or replace:
dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]).

Time Complexity: O(M * N)
Space Complexity: O(M * N)
*/

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }
}
