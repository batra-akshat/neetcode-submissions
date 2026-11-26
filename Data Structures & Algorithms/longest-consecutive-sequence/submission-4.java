class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int ans = 1;
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, true);
        }
        for(int num : nums) {
            int res = 1;
            int l = num-1, r=num+1;
            while (mp.containsKey(l)) {
                mp.remove(l);
                l--;
                res++;
            }
            while (mp.containsKey(r)) {
                mp.remove(r);
                r++;
                res++;
            }
            ans = Math.max(ans, res);
        }
        return ans;
    }
}