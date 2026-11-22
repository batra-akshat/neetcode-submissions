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
    int preIdx = 0;
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = pre.length;
        for(int i=0;i<n;i++) {
            mp.put(in[i],i);
        }
        return dfs(pre, mp, 0, n-1);
    }

    TreeNode dfs(int[] pre, Map<Integer, Integer> mp, int l, int r) {
        if(l > r) {
            return null;
        }
        int val = pre[preIdx++];
        TreeNode root = new TreeNode(val);
        Integer idx = mp.get(val);
        root.left = dfs(pre, mp, l, idx-1);
        root.right = dfs(pre, mp, idx+1, r);
        return root;
    }
}
