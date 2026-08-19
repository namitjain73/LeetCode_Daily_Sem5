// Last updated: 8/19/2026, 2:56:18 PM
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
14
15    ListNode head;
16    ListNode tail;
17    Map<Integer,ListNode> map;
18    int cap;
19
20    public LRUCache(int capacity) {
21        cap = capacity;
22        map = new HashMap<>();
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
37    }
38    
39    public void put(int key, int value) {
40        if(map.containsKey(key)){
41            ListNode node = map.get(key);
42            node.value = value;
43            map.put(key , node);
44
45            remove(node);
46            add(node);
47            return;
48        }
49
50        ListNode node = new ListNode(key , value);
51        add(node);
52        map.put(key , node);
53
54        if(map.size() > cap){
55            ListNode dummy = head.next;
56            remove(dummy);
57            map.remove(dummy.key);
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
71        old.next = node;
72        node.pre= old;
73
74        node.next = tail;
75        tail.pre = node;
76    }
77}
78
79/**
80 * Your LRUCache object will be instantiated and called as such:
81 * LRUCache obj = new LRUCache(capacity);
82 * int param_1 = obj.get(key);
83 * obj.put(key,value);
84 */