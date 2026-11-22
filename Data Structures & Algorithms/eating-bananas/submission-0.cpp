class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int mink = 1, maxk = INT_MAX/2;
        int ans = INT_MAX;
        while(mink <= maxk) {
            int mid = (mink + maxk)/2;
            if(isPossible(piles, h , mid)) {
                ans = min(ans, mid);
                maxk = mid-1;
            } else {
                mink = mid+1;
            }
        }
        return ans;
    }

    bool isPossible(vector<int> p, int h, int  k) {
        int time = 0;
        int n = p.size();
        for(int i =0;i<n;i++) {
            int t = p[i]/k;
            if(p[i]%k) {
                t++;
            }
            time +=t;
        }
        return time <=h;
    }
};
