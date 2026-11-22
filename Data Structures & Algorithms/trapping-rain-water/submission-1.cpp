class Solution {
public:
    int trap(vector<int>& a) {
        int n = a.size();
        vector<int> pre(n);
        vector<int> post(n);
        pre[0] = a[0];
        post[n-1] = a[n-1];
        for(int i=1;i<n;i++) {
            pre[i] = max(pre[i-1], a[i]);
            post[n-1-i] = max(post[n-i], a[n-1-i]);
        }
        int ans = 0;
        int i = 0;
        while(i<n) {
            int l = i, area = 0;
            while(l<n && pre[l] == pre[i]) {
                area += (pre[i] - a[l]);
                l++;
            }
            if(l<n) {
                ans += area;
            }
            i = l;
        }
        i = n-1;
        while(i>=0) {
            int l = i, area = 0;
            while(l>=0 && post[l] == post[i]) {
                area += (post[i] - a[l]);
                if(a[l] == post[l]) {
                    // add the area
                   ans += area;
                   area = 0;
                }
                l--;
            }
            if(l>=0) {
                ans += area;
            }
            i = l;
        }
        return ans;
    }
};
