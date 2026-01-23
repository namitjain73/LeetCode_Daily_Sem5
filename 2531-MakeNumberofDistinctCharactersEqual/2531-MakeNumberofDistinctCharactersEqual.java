// Last updated: 1/23/2026, 11:38:54 PM
1class Solution {
2    public boolean isItPossible(String word1, String word2) {
3        int[] f1 = getFreq(word1);
4        int[] f2 = getFreq(word2);
5        
6        for (int i = 0; i < 26; i++) {
7            for (int j = 0; j < 26; j++) {
8                if (!(f1[i] > 0 && f2[j] > 0)) {
9                    continue;
10                }
11                f1[i]--; f2[i]++;
12                f2[j]--; f1[j]++;
13                if (areCharsDistinct(f1, f2)) {
14                    return true;
15                }
16                f1[i]++; f2[j]++;
17                f1[j]--; f2[i]--;
18            }
19        }
20        
21        return false;
22    }
23    private boolean areCharsDistinct(int[] a, int[] b) {
24        int d1 = 0, d2 = 0;
25        for (int i = 0; i < 26; i++) {
26            if (a[i] > 0) d1++;
27            if (b[i] > 0) d2++;
28        }
29        
30        return d1 == d2;
31    }
32    private int[] getFreq(String s) {
33        int[] f = new int[26];
34        for (char c : s.toCharArray()) {
35            f[c - 'a']++;
36        }
37        
38        return f;
39    }
40}
41
42// TC: O(26 * 26 * 26) => O(1)
43// SC: O(26 + 26) => O(1)