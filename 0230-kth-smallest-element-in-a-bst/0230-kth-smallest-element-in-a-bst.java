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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        int last = Integer.MAX_VALUE;

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if(curr.left == null || (last >= curr.left.val && last < curr.val) ) {
                last = curr.val;
                k--;
                if(curr.right != null) stack.push(curr.right);
            } else {
                stack.push(curr);
                if(curr.left != null) stack.push(curr.left);
            }

            if(k == 0) return last;
        }

        return -1;
    }
}