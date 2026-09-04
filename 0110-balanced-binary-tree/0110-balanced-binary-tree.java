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
    private int findDepth(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 1;

        int left = (root.left == null) ? 0 : findDepth(root.left);
        int right = (root.right == null) ? 0 : findDepth(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        else return Math.max(left+1,right+1);
    }
    public boolean isBalanced(TreeNode root) {
        return findDepth(root) != -1;
    }
}