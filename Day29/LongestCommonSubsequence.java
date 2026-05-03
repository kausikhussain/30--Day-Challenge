/*
Problem: Longest Common Subsequence
Platform: LeetCode
Topic: Dynamic Programming / String

Approach:
Use a 2D DP array where dp[i][j] represents the length of the longest common
subsequence of text1[0..i-1] and text2[0..j-1].
If text1[i-1] == text2[j-1], then dp[i][j] = dp[i-1][j-1] + 1.
Else, dp[i][j] = max(dp[i-1][j], dp[i][j-1]).

Time Complexity: O(M * N)
Space Complexity: O(M * N)
*/

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }
}
