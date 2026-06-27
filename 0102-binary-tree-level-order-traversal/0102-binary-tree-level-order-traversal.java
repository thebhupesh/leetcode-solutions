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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        int level = 1;
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        q.add(new Pair<>(root,1));

        while(!q.isEmpty()) {
            Pair<TreeNode,Integer> temp = q.poll();
            TreeNode node = temp.getKey();
            Integer lvl = temp.getValue();

            if(level != lvl) {
                result.add(value);
                level++;
                value = new ArrayList<>();
            }
            
            value.add(node.val);

            if(node.left != null) q.add(new Pair<>(node.left,lvl+1));

            if(node.right != null) q.add(new Pair<>(node.right,lvl+1));
        }

        result.add(value);
        
        return result;
    }
}