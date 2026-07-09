// Last updated: 7/9/2026, 5:07:52 PM
class Solution {
        public String smallestString(String s) {
        int i = 0, n = s.length();
        char[] A = s.toCharArray();
        while(i<n&&A[i]=='a')
            i++;
        if (i==n)
            A[n- 1]='z';
        while (i<n&&A[i]!='a')
            --A[i++];
        return String.valueOf(A);
    }
}