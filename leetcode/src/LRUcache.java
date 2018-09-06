//
//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

// put 存在 更新
//     不存在

// get 存在   更新
//     不存在 return -1

//import java.util.HashMap;

class LRUcache {

    class Node{
        int key, val;
        Node next,pre;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            pre = null;
        }
    }

    int capacity;
    int count;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        count = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(count == 1) {}
            else if(node.pre != null && node.next !=null){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
            else if(node.pre == null && node.next != null){
                head = node.next;
                head.pre = null;
                tail.next = node;
                node.pre = tail;
                tail = node;
                node.next = null;
            }
            else {}
            return map.get(key).val;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(count == 1 ) {}
            else if(node.pre != null && node.next !=null){
                node.pre.next = node.next;
                node.next.pre = node.pre;
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
            else if(node.pre == null && node.next != null){
                head = node.next;
                head.pre = null;
                tail.next = node;
                node.pre = tail;
                tail = node;
                node.next = null;
            }
            else {}
            node.val = value;
        }
        else{
            Node newnode = new Node(key, value);
            if (capacity <= 0 && head.next != null) {
                Node tmp = head;
                head = head.next;
                head.pre = null;
                map.remove(tmp.key);
                capacity++;
            }
            if (capacity <= 0 && head.next == null){
                map.remove(head.key);
                head = null;
                tail = null;
                capacity ++;
            }
            if (head == null && tail == null) {
                head = newnode;
                capacity--;
            }
            else{
                tail.next = newnode;
                newnode.pre = tail;
                capacity--;
            }
            tail = newnode;
            map.put(key, newnode);
        }

    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */