/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int low = Math.min(p.val,q.val);
        int high = Math.max(p.val,q.val);

        if(low <= root.val && high >= root.val) return root;
        else if(low < root.val && high < root.val) return lowestCommonAncestor(root.left,p,q);
        else return lowestCommonAncestor(root.right,p,q);
    }
}