// Last updated: 6/8/2026, 12:23:04 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int k = 0;
4        int n = nums.length;
5        int[] arr= new int[n];
6        for(int i = 0 ; i < n;  i++){
7            if(nums[i] < pivot){
8                arr[k++] = nums[i];
9            }
10        }
11        for(int i = 0 ; i < n ; i++){
12            if(nums[i] == pivot){
13                arr[k++] = nums[i];
14            }
15        }
16        for(int i = 0 ; i < n ; i++){
17            if(nums[i] > pivot){
18                arr[k++] = nums[i];
19            }
20        }
21        return arr;
22    }
23}