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
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return ans;
    }
    int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int diff = Math.abs(lh - rh);
        System.out.println(diff);
        if(diff > 1) {
            ans = false;
        }
        return 1 + Math.max(lh,rh);
    }
}
