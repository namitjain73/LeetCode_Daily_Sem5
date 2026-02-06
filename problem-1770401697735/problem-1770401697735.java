// Last updated: 2/6/2026, 11:44:57 PM
1class TreeAncestor {
2    private ArrayList<Integer>[] levelGraph; //Tracks nodes at all levels; nodes in a level are 'inOrder' (left->right) 
3    private int[] levels, ranks; //levels is 'levelOrder' position of node(multiple nodes can have same level); ranks is 'inOrder' position of node(unique for every node)
4
5    public TreeAncestor(int n, int[] parent) {
6        //Make a graph of node and its children
7        ArrayList<Integer>[] graph = new ArrayList[n];
8        for(int i=0;i<n;i++) graph[i] = new ArrayList<>();
9        for(int i=1;i<n;i++) graph[parent[i]].add(i);
10
11        //Level-order traversal
12        Queue<Integer> q = new LinkedList<>();
13        q.add(0);
14        levels = new int[n];
15        int level = 0;
16        while(!q.isEmpty()){
17            int size = q.size();
18            while(size-->0){
19                int node = q.poll();
20                levels[node] = level;
21                for(int next: graph[node]) q.add(next);
22            }
23            level++;
24        }
25
26        //In-Order traversal
27        ranks = new int[n];
28        levelGraph = new ArrayList[level];
29        for(int i=0;i<level;i++) levelGraph[i] = new ArrayList<>();
30        inOrder(graph, 0, 0);
31    }
32
33    private int inOrder(ArrayList<Integer>[] graph, int node, int rank){
34        levelGraph[levels[node]].add(node); //add node to levelGraph; note that all existing nodes in levelGraph[levels[node]] will have smaller rank than current node
35        ranks[node] = rank; //Assign 'inOrder' position
36        for(int next: graph[node]) rank = inOrder(graph, next, ++rank); //For each child from left->right, get the maxRank used by the child subtree, add 1 and assign to next child
37        return rank; //max rank used up by subtree rooted at node
38    }
39    
40    public int getKthAncestor(int node, int k) {
41        if(node==0) return -1; //0 doesn't have an ancestor
42        int level = levels[node];
43        if(level<k) return -1; //less than k levels before node's level, i.e., less than k ancestors
44        return binarySearch(level-k, ranks[node]); //in the kth ancestor level, search for the highest rank <= rank of node
45    }
46
47    private int binarySearch(int level, int target){
48        //Basic Binary search
49        List<Integer> list = levelGraph[level];
50        int lo = 0, hi = list.size()-1, res = lo;
51        while(lo<=hi){
52            int mid = (lo+hi)/2, node = list.get(mid);
53            if(ranks[node]<=target){
54                res = node;
55                lo = mid+1;
56            }
57            else
58                hi = mid-1;
59        }
60
61        return res;
62    }
63}
64
65/**
66 * Your TreeAncestor object will be instantiated and called as such:
67 * TreeAncestor obj = new TreeAncestor(n, parent);
68 * int param_1 = obj.getKthAncestor(node,k);
69 */