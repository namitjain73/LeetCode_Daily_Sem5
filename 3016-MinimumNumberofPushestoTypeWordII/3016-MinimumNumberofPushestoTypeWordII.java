// Last updated: 7/31/2026, 10:36:26 PM
1class Solution {
2    public int minimumPushes(String word) {
3        int[] freq = new int[26];
4        for (char c : word.toCharArray()) 
5            freq[c - 'a']++;
6        
7        Arrays.sort(freq);
8        int ans = 0;
9        for (int i = 25; i >= 0 && freq[i] > 0; i--) 
10            ans += freq[i] * ((25 - i) / 8 + 1);
11        
12        return ans;
13    }
14}