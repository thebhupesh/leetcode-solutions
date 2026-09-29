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
    
    private boolean solve(TreeNode root, TreeNode subRoot, TreeNode originalSubRoot) {
        if(subRoot == null && root == null) return true;
        else if(subRoot == null || root == null) return false;

        boolean res = false;
        
        if(root.val == subRoot.val) res = solve(root.left, subRoot.left, originalSubRoot) && solve(root.right, subRoot.right, originalSubRoot);
        if(res) return true;

        if(root.val == originalSubRoot.val) res = solve(root.left, originalSubRoot.left, originalSubRoot) && solve(root.right, originalSubRoot.right, originalSubRoot);
        if(res) return true;

        return solve(root.left, originalSubRoot, originalSubRoot) || solve(root.right, originalSubRoot, originalSubRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return solve(root, subRoot, subRoot);
    }
}