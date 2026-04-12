// Last updated: 4/13/2026, 2:03:34 AM
1class Solution {
2    public int minimumDistance(String word) {
3        int n = word.length();
4        // If word has 2 or fewer letters, we can put each finger on a letter for free.
5        if (n <= 2) return 0;
6        
7        // dp[j] = minimum total distance after typing up to the current letter,
8        // with the idle finger at position j (0-25 for letters A-Z, 26 means not used yet).
9        int[] dp = new int[27];
10        for (int i = 0; i < 27; i++) dp[i] = Integer.MAX_VALUE;
11        
12        char[] w = word.toCharArray();
13        // After typing the first two letters, we have two possibilities:
14        // 1) One finger typed w[0], the other finger typed w[1] for free (cost 0 for second finger)
15        //    but then the idle finger is at w[0]? Wait, careful: actually we set:
16        // dp[26] = distance from w[1] to w[0]  (means: finger1 typed w[0], finger2 typed w[1] from free,
17        //          then the idle finger is at w[1]? Let's read the code)
18        // The original optimized solution sets:
19        dp[26] = dist(w[1], w[0]);   // one finger on w[0], the other moved from free to w[1] paying distance
20        dp[w[0] - 'A'] = 0;          // both fingers on w[0]? Actually: finger1 typed w[0] (free),
21                                     // finger2 still free (26) but we store idle finger at w[0] with cost 0.
22                                     // This means we consider that the second finger hasn't moved yet.
23        
24        // Now process the remaining letters from index 2 to n-1
25        for (int i = 2; i < n; i++) {
26            int delta = dist(w[i], w[i - 1]);   // cost if we move the finger that just typed the previous letter
27            int best = dp[26];                  // start best with the case where idle finger is free
28            
29            // For every possible idle finger position j (0..26)
30            for (int j = 0; j < 27; j++) {
31                if (dp[j] < best) {
32                    // If we use the other finger (the idle one) to type w[i],
33                    // the cost is dp[j] + distance from j to w[i] (if j != 26, else 0).
34                    int cost = (j == 26 ? 0 : dist(w[i], (char)(j + 'A')));
35                    best = Math.min(best, dp[j] + cost);
36                }
37                // For the case where we move the finger that was on the previous letter,
38                // we simply add delta to every dp[j] (because the idle finger stays where it was).
39                if (dp[j] < Integer.MAX_VALUE) dp[j] += delta;
40            }
41            // Now dp[] contains costs after adding delta (move previous finger).
42            // But we also have a new possibility: the other finger (the one we just moved)
43            // becomes idle at position w[i-1]. So we update dp[w[i-1]-'A'] with the best
44            // value we computed (which corresponds to using the idle finger for the new letter).
45            dp[w[i - 1] - 'A'] = Math.min(dp[w[i - 1] - 'A'], best);
46        }
47        
48        // After processing all letters, the answer is the smallest total cost
49        // among all possible idle finger positions.
50        int res = Integer.MAX_VALUE;
51        for (int v : dp) res = Math.min(res, v);
52        return res;
53    }
54    
55    // Manhattan distance between two letters on a standard 6-column keyboard layout.
56    private int dist(char a, char b) {
57        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
58        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
59        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
60    }
61}