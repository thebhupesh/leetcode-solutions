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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            res.add(queue.peek().val);
            int count = queue.size();

            while(count > 0) {
                TreeNode curr = queue.poll();

                if(curr.right != null) queue.offer(curr.right);
                if(curr.left != null) queue.offer(curr.left);

                count--;
            }
        }

        return res;
    }
}