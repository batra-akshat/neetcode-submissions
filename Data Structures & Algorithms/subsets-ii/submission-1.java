class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0, new ArrayList<>());
        return ans;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> res) {
        ans.add(new ArrayList<>(res));
        if(start >= nums.length) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            res.add(nums[i]);
            backTrack(nums, i + 1, res);
            res.remove(res.size() - 1);
        }
    }
}