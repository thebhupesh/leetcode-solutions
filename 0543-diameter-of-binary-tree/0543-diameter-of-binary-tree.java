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
    int val = Integer.MIN_VALUE;

    public int findDepth(TreeNode root) {
        if(root == null) return 0;

        int left = findDepth(root.left);
        int right = findDepth(root.right);

        val = Math.max(val, left+right);

        return Math.max(left+1,right+1);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return val;    
    }
}