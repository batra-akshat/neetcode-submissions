class Solution {

    record Element(Integer value, Integer frequency){};
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for(int num : nums) {
            valToFreq.put(num, valToFreq.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> b.frequency - a.frequency);
        for(var entry : valToFreq.entrySet()) {
            pq.add(new Element(entry.getKey(), entry.getValue()));
        }
        var ans = new int[k];
        int i = 0;
        while (i<k && !pq.isEmpty()) {
            ans[i] = pq.poll().value;
            i++;
        }
        return ans;
    }
}

