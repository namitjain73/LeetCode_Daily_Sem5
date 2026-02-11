// Last updated: 2/12/2026, 1:37:16 AM
1class Solution {
2    class SegTree{
3        int n;
4        int [] mint, maxt, lazy;
5    public SegTree(int n){
6        this.n = n;
7        mint = new int[4*n];
8        maxt = new int[4*n];
9        lazy = new int[4*n];
10    }
11    public void push(int node, int st, int end){
12        if(lazy[node] != 0){
13            mint[node] += lazy[node];
14            maxt[node] += lazy[node];
15            if(st != end){
16                //not a leaf node has children -> so lazy porpage to children
17                lazy[2*node+1] += lazy[node];//left
18                lazy[2*node+2] += lazy[node];//right child
19            }
20            lazy[node] = 0;
21        }
22    }
23    public void updateRange(int node, int l, int r, int ql , int qr, int val){
24        push(node,l,r);//lazy
25        if(l > qr || r < ql) return;//invalid range
26        //now if complete overlap
27        if(l >= ql && r <= qr){
28                lazy[node] += val;
29                push(node,l,r);
30                return;
31        }
32        //else some overlap , searcbot left and right childh reursively in  
33        int mid = (l+r)/2;
34        updateRange(2*node+1, l, mid, ql, qr, val);//left child
35        updateRange(2*node+2, mid+1, r, ql, qr, val);//right child
36        //after recursive fill parent
37        mint[node] = Math.min(mint[2*node+1], mint[2*node+2]);//min of left and right child
38        maxt[node] = Math.max(maxt[2*node+1], maxt[2*node+2]);//max of left and right child
39    }
40    public int leftmostz(int node, int l, int r){
41        push(node,l,r);//lazy if needed
42        if(mint[node] > 0 || maxt[node] < 0) return -1;//prune
43        if(l == r){
44            //reached leaf check if zero
45            return mint[node] == 0 ? l : -1;
46        }
47        int mid = (l+r)/2;
48        int left = leftmostz(2*node+1,l,mid);
49        if(left != -1) return left;//alrady found in left tree, dont search in right
50        return leftmostz(2*node+2, mid+1,r);//not found in left , need to search right
51    }
52    }
53    public int longestBalanced(int[] nums) {
54       int n = nums.length;
55       if(n == 0) return 0;
56       SegTree seg = new SegTree(n);
57       int maxl = 0;//actaul ans to return
58       HashMap<Integer,Integer> seen = new HashMap<>();//to tackle duplucates
59       for(int i = 0; i < n; i++){
60          int val = ((nums[i] & 1) == 0) ? 1 : -1;//even or odd using bit
61          if(seen.containsKey(nums[i])){
62            //must reduce the effect of the duplicate
63            seg.updateRange(0,0,n-1,0,seen.get(nums[i]),-val);
64          }
65          seg.updateRange(0,0,n-1,0,i,val);
66          seen.put(nums[i],i);
67          int zidx = seg.leftmostz(0,0,n-1);
68          if(zidx != -1 && zidx <= i){
69            maxl = Math.max(maxl,i-zidx+1);
70          }
71       }
72       return maxl;
73    }
74}