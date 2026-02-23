// Last updated: 2/23/2026, 8:58:54 PM
1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        Set<String> set = new HashSet<>();
4        int total = 1 << k;
5        for(int i = 0  ; i < s.length() - k + 1 ;  i++){
6            set.add(s.substring(i,i+k));
7            if(set.size() == total) return true;
8        }
9        return false;
10    }
11}