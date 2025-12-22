// Last updated: 12/22/2025, 3:19:24 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5        int delete= 0;
6        boolean[] ans = new boolean[n-1];
7        for(int i = 0 ;i < m ; i++){
8            boolean deletechar = false;
9            for(int j = 0 ; j < n -1 ; j++){
10                if(!ans[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
11                    deletechar = true;
12                    break;
13                }
14            }
15            if(deletechar){
16                delete++;
17                continue;
18            }
19
20            for(int j = 0 ; j < n -1 ; j++){
21                if(!ans[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
22                    ans[j] = true;
23                }
24            }
25        }
26        return delete;
27    }
28}