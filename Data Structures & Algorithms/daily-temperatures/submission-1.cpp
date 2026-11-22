class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        stack<int> st;
        int n = t.size();
        vector<int> nextMax(n);
        int l = 0;
        for(int i = n-1; i >=0 ; i--) {
            while(!st.empty() && t[st.top()] <= t[i]) {
                st.pop();
            }
            if(!st.empty()) {
                nextMax[i] = st.top();
            } else {
                nextMax[i] = -1;
            }
            st.push(i);
        }
        vector<int> ans(n);
        for(int i=0;i<n;i++) {
            if(nextMax[i] != -1){
                ans[i] = nextMax[i] - i;
            }
        }
        return ans;
    }
};
