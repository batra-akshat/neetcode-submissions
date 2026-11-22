class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, TreeMap<String, Integer>> adj = new HashMap<>();
        
        // Build adjacency list with counts
        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new TreeMap<>())
               .merge(ticket.get(1), 1, Integer::sum);
        }
        
        List<String> result = new ArrayList<>();
        dfs("JFK", adj, result);
        
        Collections.reverse(result);
        return result;
    }
    
    private void dfs(String source, HashMap<String, TreeMap<String, Integer>> adj, List<String> result) {
        TreeMap<String, Integer> destinations = adj.get(source);
        
        while(destinations != null && !destinations.isEmpty()) {
            // Get the lexicographically smallest destination
            String next = destinations.firstKey();
            
            // Decrement count or remove if count becomes 0
            if (destinations.get(next) == 1) {
                destinations.remove(next);
            } else {
                destinations.put(next, destinations.get(next) - 1);
            }
            
            dfs(next, adj, result);
        }
        
        result.add(source);
    }
}