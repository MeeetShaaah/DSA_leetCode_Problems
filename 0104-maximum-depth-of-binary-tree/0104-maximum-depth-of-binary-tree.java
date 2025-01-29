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

// Approach - 1, we can do BFS add the elements in list<list> and return the size of outer list; TC - SC will be O(N);

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void helper(TreeNode node, int level){
        if(result.size() == level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(node.val);
        if(node.left != null) helper(node.left, level + 1);
        if(node.right != null) helper(node.right, level + 1);
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return result.size();

        helper(root, 0);
        return result.size();    
    }
}