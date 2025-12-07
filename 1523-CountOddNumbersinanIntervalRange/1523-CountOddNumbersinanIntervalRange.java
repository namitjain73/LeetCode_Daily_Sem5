// Last updated: 12/7/2025, 1:23:50 PM
1class Solution {
2    public int countOdds(int low, int high) {
3        if(high%2==0) high--;
4        if(low%2 ==0) low++;
5        return (high-low)/2+1;
6    }
7}