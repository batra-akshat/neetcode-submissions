class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] greatest = new int[3];
        for(var triplet : triplets) {
            if (!isGreater(triplet, target)) {
                for(int i=0;i<3;i++) {
                    greatest[i] = Math.max(greatest[i], triplet[i]);
                }
            }
        }
        for(int i=0;i<3;i++) {
            if(greatest[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isGreater(int[] triplet, int[] target) {
        for(int i=0;i<triplet.length;i++) {
            if(triplet[i] > target[i]) {
                return true;
            }
        }
        return false;
    }
}