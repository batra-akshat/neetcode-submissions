class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int effectiveGas = 0;
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int idx = 0;
        for(int i=0;i<n;i++) {
            effectiveGas += (gas[i] - cost[i]);
            if(effectiveGas < 0) {
                effectiveGas = 0;
                idx = i + 1;
            }
        }
        return idx;
    }
}