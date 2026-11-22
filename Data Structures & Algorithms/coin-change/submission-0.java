class Solution {
    public int coinChange(int[] coins, int sum) {
        if(sum ==0) {
            return 0;
        }
        int [] dp = new int[sum + 1];
        for(int i=0;i<=sum;i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<coins.length;i++) {
            if(coins[i] <= sum) {
                dp[coins[i]] = 1;
            }
        }
        for(int i=1;i<=sum;i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                for(int j=0;j<coins.length;j++) {
                    if(i -coins[j] >=0  && dp[i-coins[j]] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    }
                }
            }
        }
        return dp[sum] == Integer.MAX_VALUE? -1 : dp[sum];
    }
}