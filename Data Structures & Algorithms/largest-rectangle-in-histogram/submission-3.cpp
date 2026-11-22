class Solution {
public:
    int largestRectangleArea(vector<int>& h) {
        stack<int> st;
        int maxArea = *max_element(h.begin(), h.end());
        vector<int> l = getLeftMin(h);
        vector<int> r = getRightMin(h);
        int n = h.size();
        for(int i=0;i<n;i++) {
            l[i]++;
            r[i]--;
            int width = r[i] - l[i] + 1;
            maxArea = max(maxArea, width*h[i]);
        }
        return maxArea;
    }

    vector<int> getLeftMin(vector<int> h) {
        int n = h.size();
        vector<int> l(n,-1);
        stack<int> st;
        for(int i = 0;i<n;i++) {
            while(st.size() && h[i] <= h[st.top()]) {
                st.pop();
            }
            if(st.size()) {
                l[i] = st.top();
            }
            st.push(i);
        }
        return l;
    }

    vector<int> getRightMin(vector<int> h){
        int n = h.size();
        vector<int> r(n,n);
        stack<int> st;
        for(int i = n-1;i>=0;i--) {
            while(st.size() && h[i] <= h[st.top()]) {
                st.pop();
            }
            if(st.size()) {
                r[i] = st.top();
            }
            st.push(i);
        }
        return r;
    }
};