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

        while(ptr1 != null || ptr2 != null) {
            TreeNode prev1 = prevMap.getOrDefault(ptr1, root);
            TreeNode prev2 = prevMap.getOrDefault(ptr2, root);

            // System.out.println(((ptr1 != null) ? ptr1.val : "null")+":"+((prev1 != null) ? prev1.val : "null"));
            // System.out.println(((ptr2 != null) ? ptr2.val : "null")+":"+((prev2 != null) ? prev2.val : "null"));

            if(prev1 == null && ptr1 != root) return ptr1;
            else if(prev2 == null && ptr2 != root) return ptr2;
            else if(ptr1 == ptr2) return ptr1;

            if(ptr1 != root) prevMap.put(ptr1, null);
            if(ptr2 != root) prevMap.put(ptr2, null);
            
            ptr1 = prev1;
            ptr2 = prev2;
        }

        return null;
    }
}