// Last updated: 1/20/2026, 3:38:32 PM
1class Solution {
2    public int maximumLength(String s) {
3        int n = s.length();
4        int len = 1;
5        int[][] freq = new int[26][n+1];
6        freq[s.charAt(0)-'a'][1] = 1;
7        int pre = s.charAt(0);
8
9        for(int i = 1 ; i < n ; i++){
10            char curr = s.charAt(i);
11            if(curr == pre){
12                len++;
13                freq[curr-'a'][len] += 1;
14            }else{
15                freq[curr-'a'][1] += 1;
16                pre = curr;
17                len = 1;
18            }
19        }
20
21
22        int ans = -1;
23        for(int i = 0 ; i < 26 ; i++){
24            int sum = 0;
25            for(int j = n ; j >= 0 ; j--){
26                sum += freq[i][j];
27                if(sum >= 3){
28                    ans = Math.max(ans , j);
29                    break;
30                }
31            }
32        }
33        return ans;
34    }
35}