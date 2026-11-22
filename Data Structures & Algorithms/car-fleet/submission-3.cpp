class Solution {
public:
    int carFleet(int target, vector<int>& pos, vector<int>& s) {
        int n = pos.size();
        vector<pair<int,int>> posAndSpeed(n);
        for(int i=0;i<n;i++) {
            posAndSpeed[i] = {pos[i], s[i]};
        }
        sort(posAndSpeed.begin(), posAndSpeed.end());
        reverse(posAndSpeed.begin(), posAndSpeed.end());
        vector<float> time(n);
        vector<float> st;
        for(int i =0;i<n;i++) {
            time[i] = (target - posAndSpeed[i].first) * 1.0 / posAndSpeed[i].second;
            st.push_back(time[i]);
            if(st.size()>=2 && st.back()<= st[st.size()-2]) {
                st.pop_back();
            }
        }
        return st.size();
    }
};
