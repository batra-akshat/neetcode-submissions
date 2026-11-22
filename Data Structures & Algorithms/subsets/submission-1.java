class Solution {
    private List<List<Integer>> ans;
    private List<Integer> subset;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        subset = new ArrayList<>();
        dfs(0, nums);
        return ans;
    }

    private void dfs(int i, int[] nums) {
        int n = nums.length;
        if (i == n) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums);
        subset.remove(subset.size()-1);
        dfs(i+1, nums);
    }
}