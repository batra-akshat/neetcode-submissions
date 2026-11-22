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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null) {
            return ans;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Integer res = null;
            for(int i=0;i<n;i++) {
                var top = q.poll();
                if(top !=null) {
                    res=top.val;
                    if(top.left !=null) {
                        q.add(top.left);
                    }
                    if(top.right !=null) {
                        q.add(top.right);
                    }
                }
            }
            ans.add(res);
        }
        return ans;
    }
}
