// Last updated: 4/30/2026, 5:55:59 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int l = 0;
4        int r = 0;
5
6        int[] arr =new int[256];
7
8        int max = 0;
9
10        while(r < s.length()) {
11            int ch = s.charAt(r);
12            arr[ch]++;
13            while(arr[ch] > 1) {
14                arr[s.charAt(l)]--;
15                l++;
16            }
17            
18
19            max = Math.max(max, r - l+ 1);
20            r++;
21        }
22
23        return max;
24        
25    }
26}