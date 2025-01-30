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
// This is mother fucking hard, logic is simple, the implementation is fucking hard
// Definitely didnt do this by my self,

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to store column -> { row -> list of node values }
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> nodes = new TreeMap<>();

        // BFS queue storing (node, col, row)
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int col = t.col, row = t.row;

            // Insert the node's value into the TreeMap
            nodes.putIfAbsent(col, new TreeMap<>());
            nodes.get(col).putIfAbsent(row, new ArrayList<>());
            nodes.get(col).get(row).add(node.val);

            // Add left and right children to the queue
            if (node.left != null) {
                queue.add(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.add(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Prepare the result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, List<Integer>> colMap : nodes.values()) {
            List<Integer> colValues = new ArrayList<>();
            for (List<Integer> rowValues : colMap.values()) {
                Collections.sort(rowValues); // Sort values if needed
                colValues.addAll(rowValues);
            }
            result.add(colValues);
        }
        return result;
    }
}

// Helper class to store tuple (node, row, col)
class Tuple {
    TreeNode node;
    int row, col;
    
    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
