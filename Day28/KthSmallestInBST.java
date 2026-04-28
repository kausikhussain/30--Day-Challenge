/*
Problem: Kth Smallest Element in a BST
Platform: LeetCode
Topic: Tree / DFS

Approach:
Inorder traversal of a BST visits the nodes in sorted (ascending) order.
We can perform an inorder traversal and keep track of how many nodes we have visited.
When the count reaches K, the current node's value is our answer.

Time Complexity: O(H + K) where H is the height of the tree.
Space Complexity: O(H) for the recursion stack.
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

class KthSmallestInBST {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;
        
        inorder(node.left, k);
        
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        
        inorder(node.right, k);
    }
}
