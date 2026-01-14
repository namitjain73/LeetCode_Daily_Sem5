// Last updated: 1/14/2026, 11:35:57 PM
1class Solution {
2    public class Node{
3        int val;
4        int rank;
5        Node parent;
6    }
7    HashMap<Integer,Node> mp = new HashMap<>();
8    public void createSet(int val){
9        Node nn = new Node();
10        nn.val = val;
11        nn.rank = 0;
12        nn.parent = nn;
13        mp.put(val,nn);
14    }
15
16    public int find(int v){
17        Node nn = mp.get(v);
18        return find(nn).val;
19    }
20
21    public Node find(Node nn){
22        if(nn.parent == nn){
23            return nn;
24        }
25        Node rn = find(nn.parent);
26        nn.parent = rn;
27        return rn;
28    }
29
30    public void union(int v1, int v2){
31        Node nn1 = mp.get(v1);
32        Node nn2 = mp.get(v2);
33        Node rn1 = find(nn1);
34        Node rn2 = find(nn2);
35        if(rn1.rank == rn2.rank){
36            rn1.parent = rn2;
37            rn2.rank++;
38        }
39        else if(rn1.rank > rn2.rank){
40            rn2.parent = rn1;
41        }
42        else{
43            rn1.parent = rn2;
44        }
45    }
46
47    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
48        for(int i = 0; i<n; i++){
49            createSet(i);
50        }
51
52        for(int i = 1; i<nums.length; i++){
53            if(nums[i]-nums[i-1] <= maxDiff){
54                union(i,i-1);
55            }
56        }
57
58        int i = 0;
59        boolean[] ans = new boolean[queries.length];
60        for(int[] arr : queries){
61            int a = arr[0];
62            int b = arr[1];
63            ans[i++] = find(a) == find(b);
64        }
65        return ans;
66    }
67}