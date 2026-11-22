class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        vector<int> ct1(26,0);
        int n = s1.size();
        for(int i=0;i<n;i++) {
            ct1[s1[i] - 'a']++;
        }
        int l = 0;
        vector<int> ct2(26,0);
        for(int r = 0; r<s2.size() ;r++) {
            ct2[s2[r]-'a']++;
            while(!isSubset(ct2, ct1)) {
                ct2[s2[l]-'a']--;
                l++;
            }
            if(isEqual(ct1, ct2)) {
                return true;
            }
        }
        return false;
    }
    bool isSubset(vector<int> ct2, vector<int> ct1) {
        // ct2 should be subset of ct1
        for(int i=0;i<ct1.size();i++) {
            if(ct2[i] > ct1[i])
                return false;
        }
        return true;
    }
    bool isEqual(vector<int> ct2, vector<int> ct1) {
        for(int i=0;i<ct1.size();i++) {
            if(ct2[i] !=ct1[i])
                return false;
        }
        return true;
    }
};
