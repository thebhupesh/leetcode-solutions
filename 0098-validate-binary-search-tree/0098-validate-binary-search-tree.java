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
    private boolean checkBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        else if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        else return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
}