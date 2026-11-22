class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        List<TreeNode> pathA = new ArrayList<>();
        List<TreeNode> pathB = new ArrayList<>();
        search(root, a, pathA);
        search(root, b, pathB);
        System.out.println(pathA.stream().map(treeNode -> treeNode.val).toList());
        System.out.println(pathB.stream().map(treeNode -> treeNode.val).toList());

        int i = 0;
        TreeNode ans = null;
        while (i < pathB.size() && i < pathA.size()) {
            if(pathB.get(i).val == pathA.get(i).val) {
                ans = pathB.get(i);
            }
            i++;
        }
        return ans;
    }

    Boolean search(TreeNode root, TreeNode a, List<TreeNode> path) {
        if(root == null) {
            return false;
        }
        path.add(root);
        if(root.val == a.val ) {
            return true;
        }
        if(root.val < a.val) {
            return search(root.right, a, path);
        } else {
            return search(root.left, a, path);
        }
    }
}