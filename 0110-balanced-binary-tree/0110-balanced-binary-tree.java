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
        if(root == null) return 0;

        int left = findDepth(root.left);
        int right = findDepth(root.right);

        if(left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
        else return Math.max(left+1,right+1);
    }
    public boolean isBalanced(TreeNode root) {
        return findDepth(root) != -1;
    }
}