class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int resultBit = aBit ^ bBit ^ carry;
            carry = (aBit + bBit + carry >=2) ? 1:0;
            if(resultBit !=0){
                ans += (1<<i);
            }
        }
        return ans;
    }
}
