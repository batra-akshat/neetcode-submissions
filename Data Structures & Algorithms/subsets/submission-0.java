class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int sz = ans.size();
            for (int j = 0; j < sz; j++) {
                var subset = ans.get(j);
                var subsetCopy = new ArrayList<>(subset);
                subsetCopy.add(num);
                ans.add(subsetCopy);
            }
        }
        return ans;
    }
}