class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for (int j : hand) {
            mp.put(j, mp.getOrDefault(j, 0) + 1);
        }
        if(n % groupSize != 0) {
            return false;
        }

        while (!mp.isEmpty()) {
            // Get the smallest key (TreeMap keeps keys sorted)
            int start = mp.firstKey();

            // Try to form a group of consecutive numbers starting from 'start'
            for (int i = 0; i < groupSize; i++) {
                int current = start + i;

                // Check if current number exists in map
                if (!mp.containsKey(current)) {
                    return false; // Can't form consecutive group
                }

                // Decrease frequency by 1
                mp.put(current, mp.get(current) - 1);

                // Remove key if frequency becomes 0
                if (mp.get(current) == 0) {
                    mp.remove(current);
                }
            }
        }

        return true;
    }
}