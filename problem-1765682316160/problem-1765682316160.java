// Last updated: 12/14/2025, 8:48:36 AM
1class Solution {
2    public long minMoves(int[] balance) {
3        int n = balance.length;
4        int neg = -1;
5        for(int i=0 ; i < n ; i++){
6            if(balance[i] < 0){
7                neg = i;
8                break;
9            }
10        }
11
12        if(neg == -1) return 0;
13        long need = -balance[neg];
14        long pos = 0;
15        List<long[]> ll = new ArrayList<>();
16        for(int i = 0 ;i < n ; i++){
17            if(i != neg && balance[i] > 0){
18                long dist = Math.min(Math.abs(i - neg), n - Math.abs(i - neg));
19                ll.add(new long[]{dist, balance[i]});
20                pos += balance[i];
21            }
22        }
23
24
25        if(pos < need) return -1;
26
27        ll.sort(Comparator.comparingLong(a -> a[0]));
28
29        long mov = 0;
30        for(long[] d : ll){
31            if(need == 0) break;
32
33            long take = Math.min(d[1] , need);
34            mov += take*d[0];
35            need -= take;
36        }
37        return mov;
38    }
39}