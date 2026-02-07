// Last updated: 2/7/2026, 11:06:01 PM
1class Solution {
2    public int minimumDeletions(String s) {
3        int res = 0;
4        int count = 0; // Tracks the number of 'b's seen so far
5        
6        for (char c : s.toCharArray()) {
7            if (c == 'b') {
8                count++;
9            } else if (count != 0) {
10                // Found an 'a' after 'b's.
11                // We need to delete one character to resolve this "ba" pair.
12                res++;
13                count--;
14            }
15        }
16        
17        return res;
18    }
19}