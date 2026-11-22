class Solution {
public:
    int findDuplicate(vector<int>& a) {
        int slow = 0, fast = 0;
        cout<<"slow "<<slow<<' '<<"fast "<<fast<<'\n';
        do {
            slow = a[slow];
            fast = a[a[fast]];
            cout<<"slow "<<slow<<' '<<"fast "<<fast<<'\n';
        } while(slow!=fast);
        int slow2 = 0;
        while(slow2 != slow) {
            slow = a[slow];
            slow2 = a[slow2];
        }
        return slow2;
    }
};
