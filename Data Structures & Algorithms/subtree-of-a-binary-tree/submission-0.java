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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot!=null) {
            return false;
        }
        if(isEqual(root, subRoot)) {
            return true;
        }
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean isEqual(TreeNode a, TreeNode b) {
        if(a==null && b==null) {
            return true;
        } else if (a==null) {
            return false;
        } else if (b==null) {
            return false;
        }
        return isEqual(a.right, b.right) && isEqual(a.left, b.left) && a.val == b.val;
    }
}
