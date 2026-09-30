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
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        int last = -1;
        int res = Integer.MAX_VALUE;

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            do {
                curr = stack.pop();
                if(last != -1) res = Math.min(res,curr.val-last);
                last = curr.val;
            } while(!stack.isEmpty() && curr.right == null);

            if(curr.right != null) stack.push(curr.right);
        }

        return res;

    }
}