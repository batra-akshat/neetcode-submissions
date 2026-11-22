class Solution {
    Set<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new HashSet<>();
        getCombination(nums, target, new ArrayList<>());
        return ans.stream().toList();
    }

    private void getCombination(int[] nums, int target, List<Integer> res) {
        if (target == 0) {
            ans.add(res);
        }
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                var listres = new ArrayList<>(res);
                listres.add(nums[i]);
                Collections.sort(listres);
                getCombination(nums, target - nums[i], listres);
            }
        }
    }
}