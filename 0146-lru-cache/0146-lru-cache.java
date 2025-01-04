class Node{
    int key, value;
    Node prev, next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity = 0; 

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
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
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