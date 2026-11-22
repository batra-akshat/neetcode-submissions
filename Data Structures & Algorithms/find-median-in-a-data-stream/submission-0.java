class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int x = maxHeap.size();
        int y = minHeap.size();
        if(x<=y) {
            // insert into maxheap
            if(!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        } else {
            // insert into minheap
            if(!maxHeap.isEmpty() && maxHeap.peek() > num) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }
    }

    public double findMedian() {
        int x = maxHeap.size();
        int y = minHeap.size();
        if((x+y) % 2 == 1) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek()*1.0 + minHeap.peek()*1.0)/2;
        }
    }
}
