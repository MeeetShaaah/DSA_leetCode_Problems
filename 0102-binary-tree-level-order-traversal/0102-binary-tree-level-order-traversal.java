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
// We can solve this using 2 approaches, 1 - iterative(queue), 2 - recursive

// Approach - 2, Recursive
class Solution {
    List<List<Integer>> levels = new ArrayList<>(); // class level initialization 

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode node, int level){
        if(levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(node.val);

        if(node.left != null) helper(node.left, level + 1);
        if(node.right != null) helper(node.right, level + 1);
    }
}

//  Approach - 1, Iterative using queue
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();

//         if(root == null) return result;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();
//             List<Integer> list = new ArrayList<>();

//             for(int i = 1; i <= size; i++){
//                 TreeNode node = q.poll();

//                 list.add(node.val);

//                 if(node.left != null){
//                     q.add(node.left);
//                 }

//                 if(node.right != null){
//                     q.add(node.right);
//                 }
//             }
//         result.add(list);
//         }
//     return result;
//     }
// }