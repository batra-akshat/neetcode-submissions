class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        
        // Build adjacency list with priority queue for lexicographic order
        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        List<String> result = new ArrayList<>();
        dfs("JFK", adj, result);
        
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(String source, HashMap<String, PriorityQueue<String>> adj, List<String> result) {
        PriorityQueue<String> destinations = adj.get(source);
        while(destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), adj, result);
        }
        result.add(source);
    }
}
