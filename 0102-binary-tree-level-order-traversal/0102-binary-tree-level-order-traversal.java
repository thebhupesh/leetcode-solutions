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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        int currLevel = -1;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Pair<TreeNode,Integer>> q = new ArrayDeque<>();
        q.offerLast(new Pair<>(root,0));

        while(!q.isEmpty()) {
            Pair<TreeNode,Integer> curr = q.pollFirst();
            TreeNode node = curr.getKey();
            int level = curr.getValue();

            if(level > currLevel) {
                currLevel++;
                res.add(new ArrayList<>());
            }

            List<Integer> currList = res.get(currLevel);
            currList.add(node.val);

            if(node.left != null) q.offerLast(new Pair<>(node.left,level+1));
            if(node.right != null) q.offerLast(new Pair<>(node.right,level+1));
        }

        return res;
    }
}