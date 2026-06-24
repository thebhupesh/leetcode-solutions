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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {

            return true;

        }

        Stack<Object[]> stack = new Stack<>();

        Map<TreeNode, Integer> height = new HashMap<>();

        stack.push(new Object[] { root, false });

        while (!stack.isEmpty()) {

            Object[] curr = stack.pop();

            TreeNode node = (TreeNode) curr[0];

            boolean visited = (boolean) curr[1];

            if (node == null) {

                continue;

            }

            if (!visited) {

                stack.push(new Object[] { node, true });

                stack.push(new Object[] { node.right, false });

                stack.push(new Object[] { node.left, false });

            } else {

                int left = height.getOrDefault(node.left, 0);

                int right = height.getOrDefault(node.right, 0);

                if (Math.abs(left - right) > 1) {

                    return false;

                }

                height.put(node, Math.max(left, right) + 1);

            }

        }

        return true;
    }
}