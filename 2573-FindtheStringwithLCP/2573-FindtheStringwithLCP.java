// Last updated: 4/3/2026, 11:04:33 AM
1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length;
4        char[] word = new char[n];
5        char current = 'a';
6
7        for (int i = 0; i < n; i++) {
8            if (word[i] == 0) {
9                if (current > 'z') {
10                    return "";
11                }
12                word[i] = current;
13                for (int j = i + 1; j < n; j++) {
14                    if (lcp[i][j] > 0) {
15                        word[j] = word[i];
16                    }
17                }
18                current++;
19            }
20        }
21
22        for (int i = n - 1; i >= 0; i--) {
23            for (int j = n - 1; j >= 0; j--) {
24                if (word[i] != word[j]) {
25                    if (lcp[i][j] != 0) {
26                        return "";
27                    }
28                } else {
29                    if (i == n - 1 || j == n - 1) {
30                        if (lcp[i][j] != 1) {
31                            return "";
32                        }
33                    } else {
34                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
35                            return "";
36                        }
37                    }
38                }
39            }
40        }
41
42        return new String(word);
43    }
44}