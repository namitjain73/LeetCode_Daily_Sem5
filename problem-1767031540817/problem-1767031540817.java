// Last updated: 12/29/2025, 11:35:40 PM
1class Solution {
2    public int findLengthOfShortestSubarray(int[] arr) {
3        int n = arr.length;
4        int right = n - 1;
5
6        while(right > 0 && arr[right] >= arr[right - 1]){
7            right--;
8        }
9
10        int min = right;
11        if(right == 0) return 0;
12        for(int left = 0 ; left < n ; left++){
13            if(left > 0 &&  arr[left] < arr[left-1]) break;
14
15            while(right < n && arr[left] > arr[right]){
16                right++;
17            }
18
19            min = Math.min(min , right - left - 1);
20        }
21        return min;
22    }
23}