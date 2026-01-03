// Last updated: 1/3/2026, 8:06:55 PM
1class Solution {
2    public String reversePrefix(String s, int k) {
3        if(k == 1) return s;
4        StringBuilder sb= new StringBuilder();
5
6        for(int i = 0; i < k ; i++){
7            sb.append(s.charAt(i));
8        }
9        return sb.reverse().toString() + s.substring(k);
10    }
11}