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

// I will use Queue and BFS
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                row.add(node.val);

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            if(!leftToRight){
                Collections.reverse(row);
            }

            leftToRight = !leftToRight;

            result.add(row);
        }
        return result;
    }
}