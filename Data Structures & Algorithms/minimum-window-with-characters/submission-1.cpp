class Solution {
public:
    string minWindow(string s, string t) {
        // shortest substring of s which is a superset of t
        if(s.size() < t.size())
            return "";
        if(s == t)
            return s;
        vector<int> cs(100,0);
        vector<int> ct(100,0);
        for(int i=0;i<t.size();i++) {
            ct[t[i] - 'A']++;
        }
        int l = 0;
        string ans="";
        for(int i=0;i<s.size();i++) {
            ans += "  ";
        }
        string init = ans;
        for(int r=0;r<s.size();r++) {
            string res;
            cs[s[r] - 'A']++;
            int cnt = 0;
            while(isSuperSetOrEqual(cs, ct)) {
                cs[s[l] - 'A']--;
                l++;
                cnt++;
            }
            if(cnt) {
                res = s.substr(l-1, r-l+2);
                if(res.size() < ans.size()) {
                    ans = res;
                }
            }
        }
        return ans == init? "" : ans;   
    }

    bool isSuperSetOrEqual(vector<int> cs, vector<int> ct) {
        for(int i=0;i<100;i++) {
            if(cs[i] < ct[i]){
                return false;
            }
        }
        return true;
    }
};
