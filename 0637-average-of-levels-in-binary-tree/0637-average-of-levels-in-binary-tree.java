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
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            double sum = 0;
            int len = q.size();

            for(int i=0; i<len; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }

            res.add(sum/len);
        }

        return res;
    }
}