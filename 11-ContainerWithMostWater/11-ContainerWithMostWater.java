// Last updated: 7/13/2026, 9:29:54 AM
1class Solution {
2    public int maxArea(int[] height) {
3        int i = 0;
4        int ans = 0;
5        int j = height.length-1;
6        while(i < j){
7            ans = Math.max(ans , (j-i)*Math.min(height[i],height[j]));
8            if(height[i] < height[j]) i++;
9            else j--;
10        }
11        return ans;
12    }
13}