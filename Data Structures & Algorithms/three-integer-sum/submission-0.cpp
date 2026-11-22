class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& a) {
        int n = a.size();
        set<vector<int>> ans;
        for(int i=0;i<n;i++) {
            int target = -1*a[i];
            vector<vector<int>> two = twoSum(target, i, a);
            for(auto &ele : two) {
                ele.push_back(a[i]);
                sort(ele.begin(), ele.end());
                ans.insert(ele);
            }
        }
        vector<vector<int>> res;
        for(auto ele: ans) {
            res.push_back(ele);
        }
        return res;
    }
    private:
    vector<vector<int>> twoSum(int target, int index, vector<int> a) {
        int n = a.size();
        unordered_map<int,int> mp;
        vector<vector<int>> ans;
        for(int i=0;i<n;i++) {
            if(i==index) {
                continue;
            }
            if(mp.find(target-a[i]) != mp.end()) {
                ans.push_back({target - a[i], a[i]});
            }
            mp[a[i]] = i;
        }
        return ans;
    }
};
