// Last updated: 3/31/2026, 12:50:13 AM
1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] freq = new int[52];
4
5        for (int i = 0; i < s1.length(); i++) {
6            int off = (i & 1) * 26;
7            freq[s1.charAt(i) - 'a' + off]++;
8            freq[s2.charAt(i) - 'a' + off]--;
9        }
10
11        for (int i = 0; i < 52; i++)
12            if (freq[i] != 0) return false;
13
14        return true;
15    }
16}