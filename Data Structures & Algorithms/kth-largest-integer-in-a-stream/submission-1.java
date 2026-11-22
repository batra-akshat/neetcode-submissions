class KthLargest {
    // p1 stores k largest elements, p2 stores rest
    private PriorityQueue<Integer> p1;
    private PriorityQueue<Integer> p2;
    int cap;
    public KthLargest(int k, int[] nums) {
        p1 = new PriorityQueue<>();
        p2 = new PriorityQueue<>();
        cap = k;
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = nums.length - 1; i>=0 ;i--) {
            if(cnt < k) {
                // insert in p1
                p1.add(nums[i]);
            } else {
                // insert in p2
                p2.add(nums[i]);
            }
            cnt++;
        }
    }

    public int add(int val) {
        if(p1.size() < cap) {
            p1.add(val);
        } else {
            if (val > p1.peek()) {
                int remove = p1.poll();
                p1.add(val);
                p2.add(remove);
            } else {
                p2.add(val);
            }
        }
        return p1.peek();
    }
}
