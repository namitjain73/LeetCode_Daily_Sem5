// Last updated: 1/18/2026, 11:56:45 PM
1// class Solution {
2//     int MOD = 1_000_000_007;
3
4//     public int numberOfStableArrays(int zero, int one, int limit) {
5//         long[][][] dp =  new long[zero+1][one+1][2];
6//         dp[0][0][0]=1;
7//         dp[0][0][1]=1;
8
9//         for(int i=0; i<=zero; i++){
10//             for(int j=0; j<=one; j++){
11//                 for(int k=1; k<=limit; k++){
12//                     if(i-k>=0){
13//                         dp[i][j][1]=(dp[i][j][1]+dp[i-k][j][0])%MOD;
14//                     }
15//                     if(j-k>=0){
16//                         dp[i][j][0]=(dp[i][j][0]+dp[i][j-k][1])%MOD;
17//                     }
18//                 }
19//             }
20//         }
21//         return (int)((dp[zero][one][1]+dp[zero][one][0])%MOD);
22//     }
23// }
24
25class Solution {
26    int MOD = 1_000_000_007;
27
28    public int numberOfStableArrays(int zero, int one, int limit) {
29        int[][][] dp = new int[zero + 1][one + 1][2];
30        for (int i = 1; i <= Math.min(zero, limit); i++){
31            dp[i][0][0] = 1;
32        }
33        for (int i = 1; i <= Math.min(one, limit); i++){
34            dp[0][i][1] = 1;
35        }
36
37
38        for (int i = 1; i <= zero; i++) {
39            for (int j = 1; j <= one; j++) {
40                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
41                if (i > limit){
42                    dp[i][j][0] = (dp[i][j][0] + MOD - dp[i - limit - 1][j][1]) % MOD;
43                }
44                
45                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
46                if (j > limit){
47                    dp[i][j][1] = (dp[i][j][1] + MOD - dp[i][j - limit - 1][0]) % MOD;
48                }
49            }
50        }
51        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
52    }
53}