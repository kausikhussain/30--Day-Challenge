/*
Problem: Validate Binary Search Tree
Platform: LeetCode
Topic: Trees / DFS

Approach:
Use a helper function to validate whether the current node falls within a valid range 
(min, max). Update the min/max bounds as we traverse left/right.

Time Complexity: O(n)
Space Complexity: O(h) for recursion stack
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if (node.val <= min || node.val >= max) return false;
        
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
