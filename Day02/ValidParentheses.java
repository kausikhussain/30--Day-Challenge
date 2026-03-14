/*
Problem: Valid Parentheses
Platform: LeetCode
Topic: Stack

Approach:
Iterate through the string. Push the expected closing bracket when seeing an open one.
If we see a closing bracket, check if it matches the top of the stack.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '{') st.push('}');
            else if (c == '[') st.push(']');
            else if (st.isEmpty() || st.pop() != c) return false;
        }
        
        return st.isEmpty();
    }
}
