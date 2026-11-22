class Solution {
    private boolean[] dp;

    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && j <= i + nums[i]; j++) {
                dp[j] = dp[i] || dp[j];
            }
        }
        return dp[n - 1];
    }
}