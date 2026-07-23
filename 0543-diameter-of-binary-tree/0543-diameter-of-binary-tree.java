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
    int diameter = 0;
    int findDiameter(TreeNode root) {
        if(root == null) return -1;

        int left = findDiameter(root.left)+1;
        int right = findDiameter(root.right)+1;

        diameter = Math.max(diameter, left+right);

        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);

        return diameter;
    }
}