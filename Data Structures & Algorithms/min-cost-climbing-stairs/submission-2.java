class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.min(dfs(0, cost), dfs(1, cost));
    }

    private int dfs(int start, int[] cost) {
        if(start >= cost.length) {
            return 0;
        }
        if(dp[start] != -1) {
            return dp[start];
        }
        dp[start] = cost[start] + Math.min(dfs(start+1,cost), dfs(start+2,cost));
        return dp[start];
    }
}
