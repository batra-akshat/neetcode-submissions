class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        int l = 0;
        int r = l;
        unordered_map<char,int> mp;
        int ans = 0, res=0;
        while(l<n) {
            while(r < n) {
                if(mp[s[r]] != 0) {
                    cout<<r<<" "<<mp[s[r]]<<'\n';
                    break;
                }
                mp[s[r]]++;
                res++;
                r++;
            }
            ans = max(ans, res);
            if(r >= n) {
                break;
            }
            while(mp[s[r]] !=0) {
                mp[s[l]]--;
                l++;
                res--;
            }
        }
        return ans;
    }
};
