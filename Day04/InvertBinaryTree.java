/*
Problem: Invert Binary Tree
Platform: LeetCode
Topic: Tree / Recursion

Approach:
Recursively swap the left and right children of each node.

Time Complexity: O(n)
Space Complexity: O(h) where h is height of tree (recursion stack)
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
}
