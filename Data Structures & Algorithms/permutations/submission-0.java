class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void backTrack(int[] nums, ArrayList<Integer> res, boolean[] used) {
        if(res.size() == nums.length) {
            ans.add(new ArrayList<>(res)); // Create a copy!
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                res.add(nums[i]);
                used[i] = true;
                backTrack(nums, res, used);
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
    }
}