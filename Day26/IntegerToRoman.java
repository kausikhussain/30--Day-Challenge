/*
Problem: Integer to Roman
Platform: LeetCode
Topic: Math / String

Approach:
Define values and symbols in descending order. Iterate through the values and 
subtract from the given number 'num' as long as it's greater than or equal to 
the current value, appending the corresponding symbol to the result.

Time Complexity: O(1) since there is a fixed number of operations
Space Complexity: O(1)
*/

class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < values.length && num > 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
}
