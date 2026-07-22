// Last updated: 7/23/2026, 12:23:24 AM
1import java.util.regex.*;
2
3
4class Solution {
5    private int[] zs, ze, V;
6    private int nblocks;
7    private List<int[]> sparse;
8
9    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
10        int ones = (int) s.chars().filter(c -> c == '1').count();
11
12        // maximal zero-blocks (inclusive ends), split into starts / ends
13        List<Integer> zsL = new ArrayList<>(), zeL = new ArrayList<>();
14        Matcher mo = Pattern.compile("0+").matcher(s);
15        while (mo.find()) { zsL.add(mo.start()); zeL.add(mo.end() - 1); }
16        zs = zsL.stream().mapToInt(Integer::intValue).toArray();
17        ze = zeL.stream().mapToInt(Integer::intValue).toArray();
18        nblocks = zs.length;
19
20        // valley j: full value = sum of the two adjacent block lengths
21        V = IntStream.range(0, nblocks - 1)
22                     .map(j -> (ze[j] - zs[j] + 1) + (ze[j + 1] - zs[j + 1] + 1))
23                     .toArray();
24
25        // sparse table for range-max over V
26        int nv = V.length;
27        sparse = new ArrayList<>();
28        sparse.add(V);
29        for (int half = 1; half * 2 <= nv; half *= 2) {
30            int[] prev = sparse.get(sparse.size() - 1);
31            int[] next = new int[prev.length - half];
32            for (int i = 0; i < next.length; i++)
33                next[i] = Math.max(prev[i], prev[i + half]);
34            sparse.add(next);
35        }
36
37        List<Integer> ans = new ArrayList<>(queries.length);
38        for (int[] q : queries) ans.add(ones + gain(q[0], q[1]));
39        return ans;
40    }
41
42    private int rmq(int lo, int hi) {                 // inclusive max over V[lo..hi]
43        int t = 31 - Integer.numberOfLeadingZeros(hi - lo + 1);
44        return Math.max(sparse.get(t)[lo], sparse.get(t)[hi - (1 << t) + 1]);
45    }
46
47    private int clip(int j, int l, int r) {           // valley j's gain, clipped to [l, r]
48        return V[j] - Math.max(0, l - zs[j]) - Math.max(0, ze[j + 1] - r);
49    }
50
51    private int gain(int l, int r) {
52        if (nblocks < 2) return 0;
53        int ja = lowerBound(ze, l);                   // first usable valley: left block ends >= l
54        int jb = upperBound(zs, r) - 2;               // last  usable valley: right block starts <= r
55        if (ja > jb) return 0;
56        return Math.max(Math.max(clip(ja, l, r), clip(jb, l, r)),
57                        jb - ja >= 2 ? rmq(ja + 1, jb - 1) : 0);
58    }
59
60    // bisect_left / bisect_right equivalents
61    private static int lowerBound(int[] a, int x) {
62        int lo = 0, hi = a.length;
63        while (lo < hi) { int mid = (lo + hi) >>> 1; if (a[mid] < x) lo = mid + 1; else hi = mid; }
64        return lo;
65    }
66    private static int upperBound(int[] a, int x) {
67        int lo = 0, hi = a.length;
68        while (lo < hi) { int mid = (lo + hi) >>> 1; if (a[mid] <= x) lo = mid + 1; else hi = mid; }
69        return lo;
70    }
71}