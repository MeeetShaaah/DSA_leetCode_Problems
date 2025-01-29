/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// (Self) for every parent node we can calculate the path value; 

// The algorithm is basically exploring all possible paths in the tree, from any leaf node to the root node. At each node, it does the following:

// It checks the path going down to the left and right child nodes.
// It adds the values of the left and right child nodes, as well as the current node's value (node.val).
// Then, it finds the maximum sum. [maxSum = Math.max(maxSum, left + right + node.val);]
// After that, it keeps checking other possible paths from the subtrees (left and right), choosing the best one (i.e., the one with the highest sum). [node.val + Math.max(left,right);]

// In short, it looks for the path with the highest sum in the whole tree, considering all paths that pass through each node.


class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left,right);
    }
}

// Simplified Logic:
// At each node, calculate two things:

// The maximum path sum going down to its children (node.val + max(left, right)).
// The maximum path sum through that node, which considers both left and right subtrees (left + right + node.val).
// Update the global maximum if you find a path sum greater than the current maximum.