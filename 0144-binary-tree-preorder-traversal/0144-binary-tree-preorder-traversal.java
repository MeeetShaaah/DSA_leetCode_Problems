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

// Approach - 2, Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            result.add(node.val);

            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
        return result;
    }
}

//  Approach - 1, recursive 
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();

//         helper(root, result);
//         return result;
//     }

//     private void helper(TreeNode root, List<Integer> result){
//         if(root == null) return;

//         result.add(root.val);
//         helper(root.left, result);
//         helper(root.right, result);
//     }
// }