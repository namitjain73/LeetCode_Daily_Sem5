// Last updated: 8/13/2026, 11:58:41 PM
1class Solution {
2    static class Node {
3        int len, pref, suff, best;
4        char left, right;
5
6        Node(int len, int pref, int suff, int best, char left, char right) {
7            this.len = len;
8            this.pref = pref;
9            this.suff = suff;
10            this.best = best;
11            this.left = left;
12            this.right = right;
13        }
14    }
15
16    Node[] tree;
17    char[] s;
18
19    Node merge(Node a, Node b) {
20        if (a == null) return b;
21        if (b == null) return a;
22
23        Node res = new Node(
24            a.len + b.len,
25            a.pref,
26            b.suff,
27            Math.max(a.best, b.best),
28            a.left,
29            b.right
30        );
31
32        if (a.right == b.left) {
33            res.best = Math.max(res.best, a.suff + b.pref);
34
35            if (a.pref == a.len)
36                res.pref = a.len + b.pref;
37
38            if (b.suff == b.len)
39                res.suff = b.len + a.suff;
40        }
41
42        return res;
43    }
44
45    void build(int u, int l, int r) {
46        if (l == r) {
47            tree[u] = new Node(1, 1, 1, 1, s[l], s[l]);
48            return;
49        }
50
51        int mid = (l + r) >> 1;
52
53        build(u << 1, l, mid);
54        build(u << 1 | 1, mid + 1, r);
55
56        tree[u] = merge(tree[u << 1], tree[u << 1 | 1]);
57    }
58
59    void update(int u, int l, int r, int pos, char c) {
60        if (l == r) {
61            s[pos] = c;
62            tree[u] = new Node(1, 1, 1, 1, c, c);
63            return;
64        }
65
66        int mid = (l + r) >> 1;
67
68        if (pos <= mid)
69            update(u << 1, l, mid, pos, c);
70        else
71            update(u << 1 | 1, mid + 1, r, pos, c);
72
73        tree[u] = merge(tree[u << 1], tree[u << 1 | 1]);
74    }
75
76    public int[] longestRepeating(String s, String queryCharacters,
77                                   int[] queryIndices) {
78        this.s = s.toCharArray();
79
80        int n = s.length();
81        tree = new Node[4 * n];
82
83        build(1, 0, n - 1);
84
85        int[] ans = new int[queryIndices.length];
86
87        for (int i = 0; i < queryIndices.length; ++i) {
88            update(1, 0, n - 1,
89                   queryIndices[i],
90                   queryCharacters.charAt(i));
91
92            ans[i] = tree[1].best;
93        }
94
95        return ans;
96    }
97}