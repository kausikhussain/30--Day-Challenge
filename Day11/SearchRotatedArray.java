/*
Problem: Search in Rotated Sorted Array
Platform: LeetCode
Topic: Binary Search

Approach:
Find which half is properly sorted. If target is in the range of the sorted half, 
search that half; otherwise, search the other half.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            
            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } 
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
