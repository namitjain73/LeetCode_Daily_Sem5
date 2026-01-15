// Last updated: 1/15/2026, 11:08:29 PM
1class Solution {
2    public int minValidStrings(String[] words, String target) {
3        int w[] = new int[50001], h[][] = new int[words.length + 1][50001], result = -1;
4        w[0] = 1;
5        for (int i = 1; i <= 50000; i++) {
6            w[i] = w[i - 1] * 31;
7        }
8        for (int i = 0; i <= words.length; i++) {
9            for (int j = 0; j < (i < words.length ? words[i] : target).length(); j++) {
10                h[i][j + 1] = h[i][j] + (i < words.length ? words[i] : target).charAt(j) * w[j];
11            }
12        }
13        TreeMap<Integer, Integer> tree = new TreeMap<>(Map.of(0, 1));
14        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>(Map.of(1, new ArrayList<>(List.of(0))));
15        for (int i = 0; i <= target.length(); i++) {
16            for (int v : hash.getOrDefault(i, new ArrayList<>())) {
17                tree.put(v, tree.get(v) - 1);
18                if (tree.get(v) == 0) {
19                    tree.remove(v);
20                }
21            }
22            result = tree.isEmpty() ? -1 : tree.firstKey();
23            if (!tree.isEmpty()) {
24                int left = 0;
25                for (int j = 0; j < words.length; j++) {
26                    for (int right = Math.min(words[j].length(), target.length() - i); left < right;) {
27                        int mid = (left + right + 1) / 2;
28                        if (h[words.length][mid + i] - h[words.length][i] == h[j][mid] * w[i]) {
29                            left = mid;
30                        } else {
31                            right = mid - 1;
32                        }
33                    }
34                }
35                if (left > 0) {
36                    tree.put(result + 1, tree.getOrDefault(result + 1, 0) + 1);
37                    hash.computeIfAbsent(i + left + 1, t -> new ArrayList<>()).add(result + 1);
38                }
39            }
40        }
41        return result;
42    }
43}