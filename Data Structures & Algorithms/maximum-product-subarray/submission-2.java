class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int suffix = 0, prefix = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(prefix == 0) {
                prefix = nums[i];
            } else {
                prefix *= nums[i];
            }
            if(suffix == 0) {
                suffix = nums[n-1-i];
            } else {
                suffix *= nums[n-1-i];
            }
            ans = Math.max(ans, prefix);
            ans = Math.max(ans, suffix);
        }
        return ans;
    }
}