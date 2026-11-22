class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        unordered_map<int,int> freq;
        int maxV = INT_MIN;
        for(int i=0;i<n;i++) {
            freq[nums[i]]++;
        }
        int ans = 1;
        for(int i=0;i<n;i++) {
            int init = nums[i];
            if(freq.find(init-1)==freq.end()) {
                int res=1;
                while(freq.find(init + res)!=freq.end()) {
                    res++;
                }
                ans = max(ans, res);
            }
        }
        return ans;
    }
};
