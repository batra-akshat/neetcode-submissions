class Solution {

    record Element(Integer value, Integer frequency){};
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        for(int num : nums) {
            valToFreq.put(num, valToFreq.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> a.frequency - b.frequency);
        for(var entry : valToFreq.entrySet()) {
            pq.add(new Element(entry.getKey(), entry.getValue()));
            if(pq.size() > k) {
                pq.poll();
            }
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