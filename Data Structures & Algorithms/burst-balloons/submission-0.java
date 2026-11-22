class Solution {
    private Integer[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];
        return dfs(0, n - 1, nums);
    }

    private int dfs(int l, int r, int[] nums) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        int ans = 0;
        int n = nums.length;
        for (int i = l; i <= r; i++) {
            ans = Math.max((l - 1 >= 0 ? nums[l - 1] : 1) * nums[i] * (r + 1 < n ? nums[r + 1] : 1) +
                    dfs(l, i - 1, nums) + dfs(i + 1, r, nums), ans);
        }
        dp[l][r] = ans;
        return dp[l][r];
    }
}