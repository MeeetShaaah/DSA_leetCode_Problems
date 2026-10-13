class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private Node addAtHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        return head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);

        remove(node);
        addAtHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addAtHead(node);
            return;
        }

        Node node = new Node(key, value);
        addAtHead(node);
        map.put(key, node);

        if(map.size() > capacity){
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */