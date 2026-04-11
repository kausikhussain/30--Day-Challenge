/*
Problem: Find the Duplicate Number
Platform: LeetCode
Topic: Array / Two Pointers (Floyd's Cycle Detection)

Approach:
Since the array elements are in the range [1, n], we can treat the array as a linked list
where the value points to the next index. A duplicate implies a cycle exists.
Use Floyd's tortoise and hare algorithm to detect the cycle and find its entrance.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Find intersection point in the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
