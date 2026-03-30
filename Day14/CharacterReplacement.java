/*
Problem: Longest Repeating Character Replacement
Platform: LeetCode
Topic: Sliding Window / Strings

Approach:
Keep track of the max frequency of any character in the current window.
The length of window minus max frequency gives the number of characters to replace.
If this number > k, we shrink the window by moving the left pointer.

Time Complexity: O(n)
Space Complexity: O(1) because we use an array of size 26
*/

class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, maxF = 0, res = 0;
        
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, count[s.charAt(r) - 'A']);
            
            while ((r - l + 1) - maxF > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            
            res = Math.max(res, r - l + 1);
        }
        
        return res;
    }
}
