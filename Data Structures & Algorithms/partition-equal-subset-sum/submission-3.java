class Solution {
    public boolean canPartition(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int k : a) {
            sum += k;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][sum / 2];
    }
}