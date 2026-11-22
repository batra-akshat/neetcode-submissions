
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = 0, res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            ans += nums[i];
            res = Math.max(ans, res);
            if(ans < 0) {
                ans = 0;
            }
        }
        return res;
    }
}