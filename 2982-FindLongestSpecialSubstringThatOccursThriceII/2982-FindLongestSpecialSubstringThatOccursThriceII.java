// Last updated: 2/2/2026, 11:24:31 PM
1class Solution {
2    public int maximumLength(String s) {
3        int n = s.length();
4        int[][] freq = new int[26][n+1];
5        int pre = s.charAt(0);
6        freq[s.charAt(0)-'a'][1] = 1;
7        int len = 1;
8
9        for(int i = 1 ; i < n ; i++){
10            int curr = s.charAt(i);
11            if(pre == curr){
12                len++;
13                freq[curr-'a'][len]+=1;
14            }else{
15                len = 1;
16                freq[curr-'a'][1] += 1;
17                pre = curr;
18            }
19        }
20
21        int ans = -1;
22        for(int i = 0 ; i < 26 ; i++){
23            int sum = 0;
24            for(int j = n ; j >= 0 ; j--){
25                sum += freq[i][j];
26                if(sum >= 3){
27                    ans = Math.max(ans,j);
28                    break;
29                }
30            }
31        }
32        return ans;
33    }
34}