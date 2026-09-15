// Last updated: 9/15/2026, 7:12:18 PM
1class Solution {
2    public int maxPalindromes(String s, int k) {
3        // non overlapping 
4        // each has length atleast `k` & each string is a palindrome 
5        // max no of substrings that can be formed
6        // N2, N2LogN will work 
7
8        // then can I generate non-overlapping one's out of it easily. Let me try
9        int n = s.length(); 
10        boolean[][] pal = new boolean[n][n]; 
11
12        // 1 length is alsways a palindrom 
13        for(int i = 0; i < n; i++) pal[i][i] = true; 
14
15        for(int i = 1; i < n; i++) if(s.charAt(i) == s.charAt(i - 1)) pal[i-1][i] = true; 
16
17        // fill for next length 
18        for(int len = 3; len <= n; len++) {
19            for(int j = 0; j + len <= n; j++) {
20                if(s.charAt(j) == s.charAt(j + len - 1) &&
21                pal[j + 1][j + len - 2]) {
22                    pal[j][j + len - 1] = true;
23                }
24            }
25        }
26
27
28        int dp[] = new int[n]; // where dp[i] max ending at i with length `k` 
29
30        for(int i = 0; i < n; i++) {
31            if(i > 0) dp[i] = dp[i - 1]; 
32            for(int j = 0; j <= i; j++) {
33                if(i - j >= k - 1 && pal[j][i]) {
34                    dp[i] = Math.max(dp[i], 1 + (j > 0 ? dp[j - 1] : 0)); // as we take [j..i] prev one is dp[j - 1]
35                }
36            }
37        }
38
39        return dp[n - 1]; 
40    }
41}