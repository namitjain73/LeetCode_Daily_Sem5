// Last updated: 1/31/2026, 11:06:20 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int lo = 0;
4        int n = letters.length;
5        int hi = n-1;
6        char ans = letters[0];
7        while(lo <= hi){
8            int mid = lo + (hi-lo)/2;
9            if(letters[mid] > target){
10                ans = letters[mid];
11
12                hi = mid  - 1;
13                
14            }
15            else {
16                lo = mid + 1;
17            }
18        }
19        return ans;
20        
21    }
22}