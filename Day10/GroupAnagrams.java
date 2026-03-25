/*
Problem: Group Anagrams
Platform: LeetCode
Topic: Strings / Hashing

Approach:
Sort the characters of each string to use as the key for a HashMap.
The value is a list of anagrams. Group all strings with the same sorted character array.

Time Complexity: O(n * k log k) where n is strings array length, k is max string length.
Space Complexity: O(n * k)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
