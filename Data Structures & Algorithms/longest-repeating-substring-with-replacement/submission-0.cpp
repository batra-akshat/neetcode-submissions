class Solution {
public:
    int characterReplacement(string s, int k) {
        // longest substring containing k + 1 or less distinct characters
        int n = s.size();
        int l = 0, r=0;
        unordered_map<char,int> mp;
        int ans = k;
        for(char i='A';i<='Z';i++) {
            // now we want to find the biggest substring with all i;
            // cout<<i<<'\n';
            ans=max(ans,findMaxSubLength(s,k,i));
        }
        return ans;
    }
    int findMaxSubLength(string s, int k, char c) {
        int ans = 0;
        int n = s.size();
        int l = 0 ;
        int cnt = 0;
        for(int r =0;r<n;r++) {
            if(s[r] == c) {
                cnt++;
            }
            while((r-l+1) - cnt > k) {
                if(s[l] == c) {
                    cnt--;
                }
                l++;
            }
            // cout<<"r "<<r<<" "<<"l "<<l<<'\n';
            ans = max(ans, r-l+1);
        }
        return ans;
    }
};
