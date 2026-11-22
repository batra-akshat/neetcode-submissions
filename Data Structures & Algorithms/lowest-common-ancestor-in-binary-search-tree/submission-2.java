class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        List<TreeNode> pathA = new ArrayList<>();
        List<TreeNode> pathB = new ArrayList<>();
        search(root, a, pathA);
        search(root, b, pathB);

        System.out.println(pathA.stream().map(node -> node.val).toList());
        System.out.println(pathB.stream().map(node -> node.val).toList());

        int i = 0;
        TreeNode ans = null;
        while (i < pathA.size() && i < pathB.size()) {
            if (pathA.get(i) == pathB.get(i)) {
                ans = pathA.get(i);
            }
            i++;
        }
        return ans;
    }

    boolean search(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;

        path.add(root);

        if (root.val == target.val) {
            return true;
        }

        if (target.val < root.val) {
            return search(root.left, target, path);
        } else {
            return search(root.right, target, path);
        }
    }
}
