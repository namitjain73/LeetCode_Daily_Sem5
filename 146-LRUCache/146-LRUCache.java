// Last updated: 8/19/2026, 1:30:22 AM
1class LRUCache {
2    class ListNode{
3        int key;
4        int value;
5
6        ListNode next;
7        ListNode pre;
8        public ListNode(int key , int value){
9            this.key = key;
10            this.value = value;
11        }
12    }
13
14    int cap;
15    Map<Integer,ListNode> map;
16    ListNode head;
17    ListNode tail;
18
19    public LRUCache(int capacity) {
20        cap = capacity;
21        map = new HashMap<>();
22
23        head = new ListNode(0,0);
24        tail = new ListNode(0,0);
25
26        head.next = tail;
27        tail.pre = head;
28    }
29    
30    public int get(int key) {
31        ListNode node = map.get(key);
32        if(node == null) return -1;
33
34        remove(node);
35        add(node);
36        return node.value;
37
38    }
39    
40    public void put(int key, int value) {
41        if(map.containsKey(key)){
42            ListNode node = map.get(key);
43            node.value = value;
44
45            remove(node);
46            add(node);
47            return;
48        }
49
50        ListNode node = new ListNode(key,value);
51        add(node);
52        map.put(key,node);
53
54        if(map.size() > cap){
55            ListNode lru = head.next;
56            remove(lru);
57            map.remove(lru.key);
58        }
59    }
60
61    public void remove(ListNode node){
62        ListNode old = node.pre;
63
64        old.next = node.next;
65        node.next.pre = old;
66    }
67
68    public void add(ListNode node){
69        ListNode old = tail.pre;
70
71        node.pre = old;
72        node.next = tail;
73
74        old.next = node;
75        tail.pre = node;
76
77    }
78}
79
80/**
81 * Your LRUCache object will be instantiated and called as such:
82 * LRUCache obj = new LRUCache(capacity);
83 * int param_1 = obj.get(key);
84 * obj.put(key,value);
85 */