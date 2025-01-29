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

// A balanced binary tree is a binary tree in which the height difference
// between the left and right subtrees of any node is at most 1.
// 📌 Formal Definition
// A binary tree is height-balanced if, for every node:

// abs( height(left subtree) - height(right subtree) )
// ≤
// 1
// abs( height(left subtree) - height(right subtree) )≤1
// If any node in the tree violates this condition, the tree is unbalanced.

// I am not getting the optimal solution that how it works.....
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1; 
    }

    private int height(TreeNode node){  
        if(node == null) return 0;

        int left = height(node.left);
        if(left == -1) return -1;

        int right = height(node.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left,right) + 1;
    }
}

// O(N2) solution
// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if (root == null)
//             return true;

//         int leftHeight = getHeight(root.left);
//         int rightHeight = getHeight(root.right);

//         if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
//             return true;
//         }

//         return false;
//     }

//     private int getHeight(TreeNode node) {
//         if(node == null) return 0;

//         int left = getHeight(node.left);
//         int right = getHeight(node.right);

//         return Math.max(left, right) + 1;
//     }
// }
