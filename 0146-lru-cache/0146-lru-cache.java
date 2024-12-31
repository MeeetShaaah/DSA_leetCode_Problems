//  If you're using the key to access the cache (via get(key) or put(key, value)), and if you store the key directly in the DLL node, you can quickly find, update, or remove the node from both the DLL and the HashMap in constant time (O(1)).
//  If you were passing values instead of keys (i.e., you'd only access the cache by value), then theoretically, you wouldn't need the key in the DLL because there wouldn't be a need to track which node corresponds to which key. However, this would break the functionality of a key-based LRU Cache, which is why you store both the key and the value in the DLL node in this design.
//  Thus, storing the key in the DLL is necessary for efficient key-based access and removal in an LRU Cache.
class Node{
    Node prev, next;
    int key, value;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {    
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;   
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }

        if(capacity == map.size()){
            removeNode(tail.prev);
        }

        addNode(new Node(key, value));
    }

    private void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */