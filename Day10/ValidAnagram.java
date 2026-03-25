/*
Problem: Valid Anagram
Platform: LeetCode
Topic: Strings / Hashing

Approach:
Count the frequencies of each character in the string using an integer array of size 26.
Increment for string 's' and decrement for string 't'. If all counts are 0, they are anagrams.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) return false;
        }
        
        return true;
    }
}
