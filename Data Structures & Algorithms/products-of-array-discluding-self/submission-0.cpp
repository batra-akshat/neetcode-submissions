class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> pre(n,1);
        pre[0] = nums[0];
        vector<int> post(n,1);
        post[n-1] = nums[n-1];
        for(int i=1; i<n;i++) {
            pre[i] = pre[i-1]*nums[i];
        }
        for(int i=n-2;i>=0;i--) {
            post[i] = post[i+1]*nums[i];
        }
        vector<int> ans(n,1);
        for(int i=0;i<n;i++) {
            if(i-1 >= 0) {
                ans[i] *=pre[i-1];
            }
            if(i+1 < n) {
                ans[i] *=post[i+1];
            }
        }
        return ans;
    }
};
