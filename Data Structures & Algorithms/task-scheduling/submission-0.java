class Solution {
    public int leastInterval(char[] t, int coolDown) {
        int n = t.length;
        HashMap<Character, Integer> f = new HashMap<>();
        for (char c : t) {
            f.put(c , f.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =new PriorityQueue<>((a,b) -> {
            if(b.getValue() - a.getValue() != 0) {
                return b.getValue() - a.getValue();
            }
            else return b.getKey() - a.getKey();
        });

        pq.addAll(f.entrySet());
        int ans = 0;
        while (!pq.isEmpty()) {
            int k = coolDown + 1;
            List<Map.Entry> tempList = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                var top = pq.poll();
                tempList.add(top);
                top.setValue(top.getValue()-1);
                k--;
                ans++;
            }
            for (Map.Entry<Character, Integer> e : tempList) {
                if (e.getValue() > 0) pq.add(e); // add valid tasks
            }
            if (pq.isEmpty()) break;
            ans += k;
        }

        return ans;
    }
}
