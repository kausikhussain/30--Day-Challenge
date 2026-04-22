/*
Problem: Word Break
Platform: LeetCode
Topic: Dynamic Programming / String

Approach:
Use a boolean DP array where dp[i] represents if s.substring(0, i) can be broken 
into space-separated sequence of dictionary words.
Iterate through the string, and for each position, check if any word in the dict
matches the substring ending at that position and if the string before it (dp[i-word.length()])
is also breakable.

Time Complexity: O(N * M) where N = length of string, M = average length of word
Space Complexity: O(N)
*/

import java.util.List;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
