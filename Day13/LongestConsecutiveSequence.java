/*
Problem: Longest Consecutive Sequence
Platform: LeetCode
Topic: Arrays / Hashing

Approach:
Put all numbers in a HashSet. For each number, if it's the start of a sequence 
(i.e., num - 1 is not in the set), count the length of the consecutive sequence.
Keep track of the maximum length.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        
        int maxLen = 0;
        
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentNum = n;
                int currentLen = 1;
                
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        
        return maxLen;
    }
}
