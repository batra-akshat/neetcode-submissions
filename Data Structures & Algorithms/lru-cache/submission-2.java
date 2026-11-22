class Node {
    Integer key;
    Integer val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {

    Integer capacity;
    private Node left;
    private Node right;
    private HashMap<Integer, Node> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        cache = new HashMap<>();
    }

    private void deleteNode(Node a) {
        Node prev = a.prev;
        Node next = a.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNode(Node node) {
        // insert at end of dll
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            deleteNode(node);
            insertNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        var existingNode = cache.getOrDefault(key, null);
        if(existingNode != null) {
            deleteNode(existingNode);
        }
        var node = new Node(key, value);
        cache.put(key, node);
        insertNode(node);
        if(cache.size() > capacity) {
            // remove first node
            Node lru = this.left.next;
            deleteNode(lru);
            cache.remove(lru.key);
        }


    }
}