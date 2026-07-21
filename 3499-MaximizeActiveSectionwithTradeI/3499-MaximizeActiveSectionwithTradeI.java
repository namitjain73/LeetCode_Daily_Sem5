// Last updated: 7/22/2026, 1:13:46 AM
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        int ones = 0;
4        for (char c : s.toCharArray()) {
5            if (c == '1') ones++;
6        }
7
8        String t = "1" + s + "1";
9
10        ArrayList<Character> type = new ArrayList<>();
11        ArrayList<Integer> len = new ArrayList<>();
12
13        for (char c : t.toCharArray()) {
14            if (type.isEmpty() || type.get(type.size() - 1) != c) {
15                type.add(c);
16                len.add(1);
17            } else {
18                len.set(len.size() - 1, len.get(len.size() - 1) + 1);
19            }
20        }
21
22        int best = 0;
23
24        for (int i = 1; i + 1 < type.size(); i++) {
25            if (type.get(i) == '1' &&
26                type.get(i - 1) == '0' &&
27                type.get(i + 1) == '0') {
28
29                best = Math.max(best, len.get(i - 1) + len.get(i + 1));
30            }
31        }
32
33        return ones + best;
34    }
35}