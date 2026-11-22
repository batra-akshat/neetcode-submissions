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
    private int ans;

    public int maxPathSum(TreeNode root) {
        ans = root.val;
        solve(root);
        return ans;
    }

    int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int la = Math.max(0, solve(root.left));
        int ra = Math.max(0, solve(root.right));
        ans = Math.max(ans, la + ra + root.val);
        return root.val + Math.max(la, ra);
    }
}
