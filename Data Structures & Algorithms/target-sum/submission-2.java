
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // Check if target is reachable
        if (target > sum || target < -sum || (target + sum) % 2 != 0) {
            return 0;
        }
        
        // DP array: dp[i] = number of ways to get sum i
        // Index mapping: sum s maps to index s + sum (offset = sum)
        int[] dp = new int[2 * sum + 1];
        int offset = sum;
        
        // Initialize: there's 1 way to get sum 0 (use no numbers yet)
        dp[0 + offset] = 1;  // sum 0 maps to index 0 + offset
        
        // For each number
        for (int num : nums) {
            int[] newDp = new int[2 * sum + 1];  // Create new array to avoid in-place updates
            
            // For each possible current sum
            for (int s = -sum; s <= sum; s++) {
                int idx = s + offset;
                if (dp[idx] > 0) {  // If this sum is achievable
                    // Add num: s + num
                    int addIdx = (s + num) + offset;
                    if (addIdx >= 0 && addIdx < newDp.length) {
                        newDp[addIdx] += dp[idx];
                    }
                    
                    // Subtract num: s - num
                    int subIdx = (s - num) + offset;
                    if (subIdx >= 0 && subIdx < newDp.length) {
                        newDp[subIdx] += dp[idx];
                    }
                }
            }
            dp = newDp;  // Update dp array
        }
        
        return dp[target + offset];
    }
}
