class Solution {

    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] lmin = new int[n];
        int[] rmin = new int[n];
        Arrays.fill(rmin, n);
        Arrays.fill(lmin, -1);
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            while(!st.empty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if(!st.empty()) {
                lmin[i] = st.peek();
            }
            st.push(i);
        }
        while (!st.empty()) {
            st.pop();
        }
        for(int i=n-1;i>=0;i--) {
            while(!st.empty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if(!st.empty()) {
                rmin[i] = st.peek();
            }
            st.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            lmin[i]++;
            rmin[i]--;
            int width = rmin[i] - lmin[i] + 1;
            ans = Math.max(ans, width*a[i]);
        }
        return ans;
    }
}
