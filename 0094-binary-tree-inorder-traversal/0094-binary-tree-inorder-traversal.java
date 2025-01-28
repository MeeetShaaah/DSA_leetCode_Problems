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
// Approach - 2, Iterative, (There is no wa ythat you can cracck by your own)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current != null){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            result.add(current.val);

            current = current.right;
        }
        return result;
    }
}

// Approach - 1, resursive;
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();

//         helper(root, result);

//         return result;
//     }

//     private void helper(TreeNode root, List<Integer> result){
//         if(root == null) return;

//         helper(root.left, result);
//         result.add(root.val);
//         helper(root.right, result);
//     }
// }