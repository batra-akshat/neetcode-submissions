class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int jumps = 0;          // Number of jumps made
        int currentEnd = 0;     // Farthest position reachable with current jumps
        int farthest = 0;       // Farthest position reachable overall
        
        // Don't need to consider the last position since we're trying to reach it
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we've reached the end of current jump range, make another jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Early termination: if we can reach the end
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}