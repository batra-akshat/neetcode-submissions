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
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int n = q.size();
            System.out.println(n);
            for (int i =0;i<n;i++) {
                var top = q.poll();
                if(top !=null) {
                    res.add(top.val);
                }
                if(top!=null && top.left !=null) {
                    q.add(top.left);
                }
                if(top!=null && top.right !=null) {
                    q.add(top.right);
                }
            }
            if(!res.isEmpty()) {
                ans.add(res);
            }
        }
        return ans;
    }
}

