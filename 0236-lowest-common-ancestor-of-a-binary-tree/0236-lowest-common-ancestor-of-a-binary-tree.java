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
        Map<TreeNode, TreeNode> prevMap = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        prevMap.put(root, null);

        while(!qu.isEmpty()) {
            TreeNode curr = qu.poll();

            if(curr.left != null) {
                qu.offer(curr.left);
                prevMap.put(curr.left, curr);
            }
            if(curr.right != null) {
                qu.offer(curr.right);
                prevMap.put(curr.right, curr);
            }
        }

        TreeNode ptr1 = p; 
        TreeNode ptr2 = q;

        while(true) {
            TreeNode prev1 = prevMap.get(ptr1);
            TreeNode prev2 = prevMap.get(ptr2);

            if(prev1 == null && ptr1 != root) return ptr1;
            else if(prev2 == null && ptr2 != root) return ptr2;
            else if(ptr1 == ptr2) return ptr1;

            prevMap.put(ptr1, null);
            prevMap.put(ptr2, null);
            
            if(prev1 != null) ptr1 = prev1;
            if(prev2 != null) ptr2 = prev2;
        }
    }
}