// Last updated: 12/24/2025, 12:17:05 PM
1class Solution {
2        public String smallestString(String s) {
3        int i = 0, n = s.length();
4        char[] A = s.toCharArray();
5        while(i<n&&A[i]=='a')
6            i++;
7        if (i==n)
8            A[n- 1]='z';
9        while (i<n&&A[i]!='a')
10            --A[i++];
11        return String.valueOf(A);
12    }
13}