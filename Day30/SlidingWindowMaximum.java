/*
Problem: Sliding Window Maximum
Platform: LeetCode
Topic: Array / Sliding Window / Deque

Approach:
Use a Deque (Double-Ended Queue) to store indices of array elements.
The deque will maintain the indices in a way that the corresponding elements are in 
decreasing order. The front of the deque will always store the index of the maximum 
element for the current window.
Remove indices from the front if they are out of the current window.
Remove indices from the back if the corresponding elements are smaller than the 
current element, because they can never be the maximum in the current or future windows.

Time Complexity: O(N) where N is the number of elements in the array.
Space Complexity: O(K) where K is the size of the window.
*/

import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements not within the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove elements smaller than the currently added element
            // (they are useless as the current element is larger and will survive longer)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // If window has k elements, add to result
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
