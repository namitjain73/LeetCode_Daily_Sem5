// Last updated: 9/18/2026, 10:02:16 PM
1class Solution {
2    public List<String> maxNumOfSubstrings(String s) {
3        int[] count = new int[26];
4        int[] first = new int[26];
5        int[] last = new int[26];
6
7        Arrays.fill(first, -1);
8        Arrays.fill(last, -1);
9
10        List<Integer> order = new ArrayList<>();
11
12        for (int i = 0; i < s.length(); i++) {
13            int c = s.charAt(i) - 'a';
14
15            if (count[c] == 0) {
16                first[c] = i;
17                order.add(c);
18            }
19
20            count[c]++;
21            last[c] = i;
22        }
23
24        List<String> res = new ArrayList<>();
25        Deque<int[]> queue = new ArrayDeque<>();
26
27        for (int c : order) {
28            queue.addFirst(new int[]{
29                first[c], last[c], count[c]
30            });
31
32            int left = Integer.MAX_VALUE;
33            int right = Integer.MIN_VALUE;
34            int total = 0;
35
36            for (int[] item : queue) {
37                total += item[2];
38                left = Math.min(left, item[0]);
39                right = Math.max(right, item[1]);
40
41                if (total == right - left + 1) {
42                    break;
43                }
44            }
45
46            if (total == right - left + 1) {
47                res.add(s.substring(left, right + 1));
48                queue.clear();
49            }
50        }
51
52        return res;
53    }
54}