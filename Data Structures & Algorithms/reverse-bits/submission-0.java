class Solution {
    public int reverseBits(int n) {
        List<Integer> bits = new ArrayList<>();
        for(int i=0;i<32;i++) {
            if((n&(1<<i)) != 0){
                bits.add(1);
            } else {
                bits.add(0);
            }
        }
        int ans = 0;
        for (int i = 0; i < bits.size(); i++) {
            ans += (bits.get(i) << (31 - i));  // Decreasing positions: 31, 30, 29, ...
        }
        return ans;
    }
}