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
// Didnt do this by my self, used chatGPT, the question itself is too long and boaring, 
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Step 1: Add root if it's not a leaf
        if (!isLeaf(root)) {
            result.add(root.val);
        }

        // Step 2: Collect left boundary (excluding leaves)
        collectLeftBoundary(root.left, result);

        // Step 3: Collect all leaf nodes
        collectLeaves(root, result);

        // Step 4: Collect right boundary (excluding leaves, but in reverse order)
        List<Integer> rightBoundary = new ArrayList<>();
        collectRightBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    // Helper function to check if a node is a leaf
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    // Collect left boundary (excluding leaves)
    private void collectLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Collect all leaf nodes in left-to-right order
    private void collectLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
        } else {
            collectLeaves(node.left, result);
            collectLeaves(node.right, result);
        }
    }

    // Collect right boundary (excluding leaves, stored in a separate list)
    private void collectRightBoundary(TreeNode node, List<Integer> rightBoundary) {
        while (node != null) {
            if (!isLeaf(node)) {
                rightBoundary.add(node.val);
            }
            node = (node.right != null) ? node.right : node.left;
        }
    }
}