class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, target, 0, new ArrayList<>());
        return ans;
    }

    private void backTrack(int[] nums, int target, int start, List<Integer> res) {
        if (target == 0) {
            ans.add(new ArrayList<>(res));
        }
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if (target - nums[i] >= 0) {
                res.add(nums[i]);
                backTrack(nums, target - nums[i], i + 1, res);
                res.remove(res.size() - 1);
            }
        }
    }
}