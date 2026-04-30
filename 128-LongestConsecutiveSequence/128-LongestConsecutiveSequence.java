// Last updated: 4/30/2026, 6:26:21 PM
1class Solution {
2    public String longestPalindrome(String s) {
3        int len = 0;
4        String ans = "";
5        int n = s.length();
6        for(int i = 0 ; i < n ; i++){
7            int l = i;
8            int r = i;
9
10            while((l >= 0 && r < n) && s.charAt(l) == s.charAt(r)){
11                if(len < (r - l + 1)){
12                    len= r - l + 1;
13                    ans = s.substring(l , r+1);
14                }
15                l--;
16                r++;
17            }
18            
19            l = i;
20            r = i+1;
21            while((l >= 0 && r < n) && s.charAt(l) == s.charAt(r)){
22                if(len < (r - l + 1)){
23                    len= r - l + 1;
24                    ans = s.substring(l , r+1);
25                }
26                l--;
27                r++;
28            }
29        }
30        return ans; 
31    }
32}