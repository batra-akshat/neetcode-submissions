class LRUCache {

    Integer capacity;
    Map<Integer, Integer> mp;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new LinkedHashMap<>(capacity, .75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return mp.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        mp.put(key, value);
    }
}
