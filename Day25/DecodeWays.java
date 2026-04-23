/*
Problem: Decode Ways
Platform: LeetCode
Topic: Dynamic Programming / String

Approach:
Use a DP array where dp[i] represents number of ways to decode substring s(0...i-1).
If the current character is not '0', it can be decoded by itself: dp[i] += dp[i-1].
If the current character and the previous character form a valid number between "10" and "26",
they can be decoded together: dp[i] += dp[i-2].

Time Complexity: O(N)
Space Complexity: O(N) which can be optimized to O(1)
*/

class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; // 1 way to decode an empty string
        dp[1] = 1; // 1 way to decode the first char since it's not '0'
        
        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
