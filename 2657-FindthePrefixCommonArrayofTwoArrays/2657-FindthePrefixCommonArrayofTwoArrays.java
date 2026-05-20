// Last updated: 5/20/2026, 11:03:05 PM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        HashMap<Integer, Integer> mp = new HashMap<>();
4
5        int count = 0;
6
7        for(int i = 0; i < A.length; i++) {
8
9            if(A[i] == B[i]) {
10                mp.put(A[i],
11                mp.getOrDefault(A[i], 0) + 2);
12                count++;
13            }
14
15            else {
16                mp.put(A[i],
17                mp.getOrDefault(A[i], 0) + 1);
18
19                mp.put(B[i],
20                mp.getOrDefault(B[i], 0) + 1);
21
22                if(mp.get(A[i]) == 2) {
23                    count++;
24                }
25                if(mp.get(B[i]) == 2) {
26                    count++;
27                }
28            }
29
30            A[i] = count;
31        }
32
33        return A;
34    }
35}