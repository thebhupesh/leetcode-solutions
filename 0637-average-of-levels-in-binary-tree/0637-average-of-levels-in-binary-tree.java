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
    public List<Double> averageOfLevels(TreeNode root) {
        double sum = 0;
        int count = 0;
        int level = 1;

        Deque<Pair<TreeNode,Integer>> q = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();

        q.offer(new Pair<>(root,1));

        while(!q.isEmpty()) {
            Pair<TreeNode,Integer> curr = q.poll();
            TreeNode node = curr.getKey();
            int lvl = curr.getValue();

            if(lvl != level) {
                res.add(sum/count);
                level = lvl;
                count = 1;
                sum = node.val;
            } else {
                sum += node.val;
                count++;
            }

            if(node.left != null) q.offer(new Pair<>(node.left,lvl+1));
            if(node.right != null) q.offer(new Pair<>(node.right,lvl+1));
        }

        res.add(sum/count);

        return res;
    }
}