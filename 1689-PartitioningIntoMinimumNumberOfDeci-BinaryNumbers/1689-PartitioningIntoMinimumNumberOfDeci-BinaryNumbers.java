// Last updated: 3/1/2026, 1:38:59 PM
1class Solution {
2    public int minPartitions(String n) {
3        int max = 0;
4        for(char ch : n.toCharArray()){
5            max = Math.max(max , (ch - '0') );
6            if(max == 9) break;
7        }
8        return max;
9    }
10}