class Solution {
public:
    int search(vector<int>& a, int tar) {
        int n = a.size();
        int l =0, r= n-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(a[mid] == tar) {
                return mid;
            } else if(a[mid] > tar) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }
};
