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
// Iterative Approach using 1 stack is bit complex; 
// Iterative using 2 stack;
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            s2.push(node);

            if(node.left != null) s1.push(node.left);
            if(node.right != null) s1.push(node.right);
        }

        while(!s2.isEmpty()){
            result.add(s2.pop().val);
        }
        return result;
    }
}

// Recursive
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//       List<Integer> result = new ArrayList<>();

//       helper(root, result);

//       return result;  
//     }

//     private void helper(TreeNode root, List<Integer> result){
//         if(root == null) return;

//         helper(root.left, result);
//         helper(root.right, result);
//         result.add(root.val);
//     }
// }