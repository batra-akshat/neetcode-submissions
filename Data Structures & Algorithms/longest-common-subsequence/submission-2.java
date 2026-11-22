class Solution {
    Integer[][] dp;

    public int longestCommonSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new Integer[n + 1][m + 1];
        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        int ans = 0;
        if(i == s.length() || j == t.length()) {
            return 0;
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            ans = 1 + dfs(i + 1, j + 1, s, t);
        } else {
            ans = Math.max(dfs(i, j + 1, s, t), dfs(i + 1, j, s, t));
        }
        dp[i][j] = ans;
        return ans;
    }
}