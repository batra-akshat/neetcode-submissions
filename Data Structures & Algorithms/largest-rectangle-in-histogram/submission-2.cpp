class Solution {
public:
    int largestRectangleArea(vector<int>& h) {
        stack<int> st;
        int maxArea = *max_element(h.begin(), h.end());
        vector<int> l = getLeftMin(h);
        vector<int> r = getRightMin(h);
        int n = h.size();
        for(auto ele : l) {
            cout<<ele<<' ';
        }
        cout<<'\n';
        for(auto ele : r) {
            cout<<ele<<' ';
        }
        cout<<'\n';
        for(int i=0;i<n;i++) {
            int width;
            if(l[i] != -1 && r[i] != n) {
                width = r[i] - l[i] -1;
            } else if(l[i] == -1 && r[i] !=n) {
                width = r[i];
            } else if(r[i] == n && l[i]!=-1) {
                width = n - 1 - l[i];
            } else {
                width = n;
            }
            cout<<width<<'\n';
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