// Last updated: 4/30/2026, 5:56:50 PM
1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int l = 0;
4        int sum = 0;
5        int max = 0;
6        int n = s.length();
7        int[] arr = new int[256];
8        for(int r = 0; r < n; r++){
9            arr[s.charAt(r)]++;
10            while(arr[s.charAt(r)] > 1){
11                arr[s.charAt(l)]--;
12                l++;
13            }
14            max = Math.max(max , r-l+1);
15        }
16        return max;
17    }
18}