class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) return 0;
        
        // Use a priority queue to store [cost, pointIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];
        
        // Start from point 0
        pq.offer(new int[]{0, 0}); // [cost, pointIndex]
        int totalCost = 0;
        int edgesUsed = 0;
        
        while (!pq.isEmpty() && edgesUsed < n) {
            int[] current = pq.poll();
            int cost = current[0];
            int pointIndex = current[1];
            
            // Skip if already visited
            if (visited[pointIndex]) {
                continue;
            }
            
            // Mark as visited and add cost
            visited[pointIndex] = true;
            totalCost += cost;
            edgesUsed++;
            
            // Add all edges from current point to unvisited points
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int manhattanDistance = Math.abs(points[pointIndex][0] - points[i][0]) + 
                                          Math.abs(points[pointIndex][1] - points[i][1]);
                    pq.offer(new int[]{manhattanDistance, i});
                }
            }
        }
        
        return totalCost;
    }
}