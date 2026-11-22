class Solution {
    public int[] twoSum(int[] nums, int t) {
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(valToIdx.containsKey(t - nums[i])) {
                return new int[]{valToIdx.get(t-nums[i]), i};
            }
            valToIdx.putIfAbsent(nums[i],i);
        }
        return new int[]{};
    }
}