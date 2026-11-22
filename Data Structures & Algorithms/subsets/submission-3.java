class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0, new ArrayList<>());
        return ans;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> res) {
        ans.add(new ArrayList<>(res));
        for(int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            backTrack(nums, i + 1, res);
            res.remove(res.size() - 1);
        }
    }
}