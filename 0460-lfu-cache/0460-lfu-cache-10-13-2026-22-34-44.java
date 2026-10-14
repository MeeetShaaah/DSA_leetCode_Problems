class LFUCache {
    private class Node {
        int key;
        int value;
        int freq = 1;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DLL {
        private Node head;
        private Node tail;
        private int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        private Node removeFromTail() {
            Node last = tail.prev;
            remove(last);
            return last;
        }

        void addAtHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
    }

    int capacity;
    int minFreq;
    Map<Integer, Node> keyMap;
    Map<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private DLL getList(int freq) {
        if (!freqMap.containsKey(freq)) {
            freqMap.put(freq, new DLL());
        }

        return freqMap.get(freq);
    }

    public void updateFreq(Node node) {
        DLL oldList = freqMap.get(node.freq);
        oldList.remove(node);

        if (node.freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = getList(node.freq);
        newList.addAtHead(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key))
            return -1;

        Node node = keyMap.get(key);

        updateFreq(node);

        return node.value;

    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.value = value;

            updateFreq(node);

            return;
        }

        if(keyMap.size() == capacity){
            DLL list = freqMap.get(minFreq);
            Node removal = list.removeFromTail();
            keyMap.remove(removal.key);
        }

        Node node = new Node(key, value);
        keyMap.put(key, node);

        DLL list = getList(1);
        list.addAtHead(node);

        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */