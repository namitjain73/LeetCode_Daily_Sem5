// Last updated: 8/21/2026, 11:01:48 PM
1class Solution {
2
3    public long findKthSmallest(int[] coins, int k) {
4        Arrays.sort(coins);
5        if (coins[0] == 1) return k;
6        int n = coins.length, r = 0, c, j;
7        for (int i = 0; i < n - r - 1; i++) {
8            c = coins[i];
9            j = i + 1;
10            while (j < n - r) {
11                if (coins[j] % c == 0) {
12                    for (int x = j; x < n - r - 1; x++) {
13                        coins[x] = coins[x + 1];
14                    }
15                    r++;
16                } else {
17                    j++;
18                }
19            }
20        }
21        if (n - r == 1) {
22            return (long) coins[0] * k;
23        }
24        int a = n - r;
25        long low = coins[0];
26        long high = (long) coins[0] * k;
27        long count;
28        long result = 0;
29        while (low <= high) {
30            long mid = low + (high - low) / 2;
31            count = countNums(coins, mid, a);
32            if (count >= k) {
33                result = mid;
34                high = mid - 1;
35            } else {
36                low = mid + 1;
37            }
38        }
39        return result;
40    }
41
42    int gcd(int a, int b) {
43        int r;
44        while (b > 0) {
45            r = a % b;
46            a = b;
47            b = r;
48        }
49        return a;
50    }
51    long lcm(long a, long b) {
52        return a / gcd((int)a, (int)b) * b;
53    }
54    long countNums(int[] c, long m, int a) {
55        long sum = 0;
56        int totalMasks = 1 << a;
57        for (int mask = 1; mask < totalMasks; mask++) {
58            long common = 1;
59            int bits = 0;
60            for (int i = 0; i < a; i++) {
61                if ((mask & (1 << i)) != 0) {
62                    common = lcm(common, c[i]);
63                    bits++;
64                }
65            }
66
67            if ((bits & 1) == 1) {
68                sum += m / common;
69            } else {
70                sum -= m / common;
71            }
72        }
73
74        return sum;
75    }
76}