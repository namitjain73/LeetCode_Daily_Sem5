// Last updated: 12/27/2025, 11:53:10 PM
1class Solution {
2    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
3        int[] arr = arrivals;
4        int dis = 0;
5        Map<Integer,List<Integer>> ki = new HashMap<>();
6        Map<Integer,Integer> si = new HashMap<>();
7        for(int i= 0 ; i < arrivals.length ; i++){
8            int d = i+1;
9            int it = arrivals[i];
10            ki.putIfAbsent(it,new ArrayList<>());
11            si.putIfAbsent(it,0);
12            List<Integer> dk = ki.get(it);
13            int s = si.get(it);
14            int ws = Math.max(1 ,d-w+1);
15                while(s  < dk.size() && dk.get(s) < ws){
16                    s++;
17                }
18
19            si.put(it,s);
20            int c= dk.size() - s;
21            if(c   < m){
22                dk.add(d);
23            }else{
24                dis++;
25            }
26        }
27        return dis;
28    }
29}