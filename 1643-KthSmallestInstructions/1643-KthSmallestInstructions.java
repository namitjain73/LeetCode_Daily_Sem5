// Last updated: 1/31/2026, 11:07:12 PM
1class Solution {
2    public String kthSmallestPath(int[] destination, int k) {
3        
4        int ti = destination[0], tj = destination[1];
5        int[][] dp = new int[ti+1][tj+1];
6        for(int i = ti; i >= 0; i--){
7            for(int j = tj; j >= 0; j--){
8                if(i == ti && j == tj){
9                    dp[i][j] = 1;
10                }else if(i == ti){
11                    dp[i][j] = dp[i][j+1];
12                }else if(j == tj){
13                    dp[i][j] = dp[i+1][j];
14                }else{
15                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
16                }
17            }
18        }
19     
20        StringBuilder sb = new StringBuilder();
21        helper(dp, 0, 0, k, sb);
22        return sb.toString();
23    }
24    
25    private void helper(int[][] dp, int i, int j, int k, StringBuilder sb){
26        
27        if(i == dp.length -1){
28            while(++j < dp[0].length)sb.append("H");
29            return;
30        }
31        if(j == dp[0].length - 1){
32            
33            while(++i < dp.length)sb.append("V");
34            return;
35        }
36        if(dp[i][j+1] >= k){
37          
38            sb.append("H");
39            helper(dp, i, j+1, k, sb);
40        }else{
41       
42            sb.append("V");
43            helper(dp, i+1, j, k-dp[i][j+1], sb);
44        }
45    }
46}