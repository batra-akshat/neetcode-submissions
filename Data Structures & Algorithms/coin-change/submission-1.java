
class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = dfs(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (dp[amount] != Integer.MAX_VALUE) return dp[amount];

        for (int coin : coins) {
            if (amount - coin >= 0) {
                int sub = dfs(coins, amount - coin);
                if (sub != Integer.MAX_VALUE) {
                    dp[amount] = Math.min(dp[amount], sub + 1);
                }
            } else {
                break;
            }
        }
        return dp[amount];
    }
}