// Last updated: 4/1/2026, 1:43:23 AM
1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length();
4        int m = str2.length();
5        char[] s = new char[n + m - 1];
6        int[] fixed = new int[n + m - 1];
7
8        for (int i = 0; i < s.length; i++) {
9            s[i] = 'a';
10        }
11
12        for (int i = 0; i < n; i++) {
13            if (str1.charAt(i) == 'T') {
14                for (int j = i; j < i + m; j++) {
15                    if (fixed[j] == 1 && s[j] != str2.charAt(j - i)) {
16                        return "";
17                    } else {
18                        s[j] = str2.charAt(j - i);
19                        fixed[j] = 1;
20                    }
21                }
22            }
23        }
24
25        for (int i = 0; i < n; i++) {
26            if (str1.charAt(i) == 'F') {
27                boolean flag = false;
28                int idx = -1;
29                for (int j = i + m - 1; j >= i; j--) {
30                    if (str2.charAt(j - i) != s[j]) {
31                        flag = true;
32                    }
33                    if (idx == -1 && fixed[j] == 0) {
34                        idx = j;
35                    }
36                }
37                if (flag) {
38                    continue;
39                } else if (idx != -1) {
40                    s[idx] = 'b';
41                } else {
42                    return "";
43                }
44            }
45        }
46        return new String(s);
47    }
48}