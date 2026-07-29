// Last updated: 7/29/2026, 6:54:38 PM
1class Solution {
2    long comb(int n, int r, int lim) {
3        r = Math.min(r, n - r);
4        long ans = 1;
5
6        for (int i = 1; i <= r; i++) {
7            ans = ans * (n - r + i) / i;
8            if (ans > lim) return lim + 1L;
9        }
10
11        return ans;
12    }
13
14    long calc(int[] cnt, int rem, int lim) {
15        long ans = 1;
16
17        for (int x : cnt) {
18            if (x == 0) continue;
19
20            ans *= comb(rem, x, lim);
21            if (ans > lim) return lim + 1L;
22
23            rem -= x;
24        }
25
26        return ans;
27    }
28
29    public String smallestPalindrome(String s, int k) {
30        int[] cnt = new int[26];
31
32        for (char c : s.toCharArray())
33            cnt[c - 'a']++;
34
35        int n = s.length(), m = n / 2;
36        char[] ans = new char[n];
37
38        for (int i = 0; i < 26; i++) {
39            if ((cnt[i] & 1) == 1)
40                ans[m] = (char) ('a' + i);
41
42            cnt[i] /= 2;
43        }
44
45        if (calc(cnt, m, k) < k)
46            return "";
47
48        for (int i = 0; i < m; i++) {
49            for (int c = 0; c < 26; c++) {
50                if (cnt[c] == 0) continue;
51
52                cnt[c]--;
53                long cur = calc(cnt, m - i - 1, k);
54
55                if (cur >= k) {
56                    ans[i] = (char) ('a' + c);
57                    break;
58                }
59
60                k -= cur;
61                cnt[c]++;
62            }
63        }
64
65        for (int i = 0; i < m; i++)
66            ans[n - 1 - i] = ans[i];
67
68        return new String(ans);
69    }
70}