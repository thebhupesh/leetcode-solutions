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
    private int[] findAverage(TreeNode root) {
        if(root == null) return new int[]{0,0,0};

        int[] left = findAverage(root.left);
        int[] right = findAverage(root.right);

        int count = left[1]+right[1]+1;
        int sum = left[2]+right[2]+root.val;
        int avg = (count > 0) ? sum/count : 0;
        int res = left[0]+right[0]+((avg == root.val) ? 1 : 0);

        return new int[]{res,count,sum};
    }

    public int averageOfSubtree(TreeNode root) {
        return findAverage(root)[0];
    }
}