class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& a, int k) {
        map<int, int> mp;
        for(int i=0;i<k;i++) {
            mp[a[i]]++;
        }
        int n = a.size();
        vector<int> ans(n-k+1);
        ans[0] = mp.rbegin()->first;
        for(int i=k;i<n;i++) {
            mp[a[i-k]]--;
            if(mp[a[i-k]] == 0){
                mp.erase(a[i-k]);
            }
            mp[a[i]]++;
            ans[i-k+1] = mp.rbegin()->first;
        }
        return ans;
    }
};
