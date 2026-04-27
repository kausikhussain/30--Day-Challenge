/*
Problem: Roman to Integer
Platform: LeetCode
Topic: Math / String

Approach:
Map each Roman numeral character to its integer value. Iterate through the string from 
left to right. If the current character's value is less than the next character's value,
subtract it (like IV = 5 - 1 = 4). Otherwise, add it.

Time Complexity: O(N) where N is length of string
Space Complexity: O(1)
*/

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        
        return result;
    }
}
