/*
Problem: Merge Two Sorted Lists
Platform: LeetCode
Topic: Linked List

Approach:
Use a dummy head and a pointer. Compare the heads of both lists and attach the smaller one to the pointer.
Append the remaining list if one gets exhausted.

Time Complexity: O(n + m)
Space Complexity: O(1)
*/

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
