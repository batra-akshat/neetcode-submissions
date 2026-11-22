class Solution {
    public int lengthOfLIS(int[] a) {
        int n  = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++) {
            for(int j = i-1;j>=0;j--) {
                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
                // Return the maximum value in dp array
        int maxLength = dp[0];
        for (int i = 1; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

