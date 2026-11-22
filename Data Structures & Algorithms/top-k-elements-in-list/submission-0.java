class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        int n = nums.length;
        for(int i =0 ; i < n ; i++) {
            numToFreq.put(nums[i], numToFreq.getOrDefault(nums[i], 0) + 1);
        }
        List<List<Integer>> freqToNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            freqToNums.add(new ArrayList<>());  // each inner list starts empty
        }
        for(var entry : numToFreq.entrySet()) {
            freqToNums.get(entry.getValue()-1).add(entry.getKey());
        }
        int ans[] = new int[k];
        int ansPointer = 0;
        for(int i=n-1;i>=0;i--) {
            var numbers = freqToNums.get(i);
            for(int j = 0; j < numbers.size(); j++) {
                ans[ansPointer] = numbers.get(j);
                ansPointer++;
                if(ansPointer == k) {
                    return ans;
                }
            }
        }
        return ans;
    }
}
