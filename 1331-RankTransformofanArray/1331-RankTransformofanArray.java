// Last updated: 7/12/2026, 1:09:48 PM
1class Solution {
2    public int[] arrayRankTransform(int[] arr) {
3        Map<Integer,Integer> map = new HashMap<>();
4        int n = arr.length;
5        int[] nums = new int[n];
6        for(int i = 0 ; i < n ; i++){
7            nums[i] = arr[i];
8        }
9        Arrays.sort(nums);
10        int c = 1;
11        int pre = Integer.MIN_VALUE;
12        for(int i = 0 ; i < n ; i++) {
13            if(pre != nums[i]){
14                map.put(nums[i] , c);
15                c++;
16            }
17            pre = nums[i]; 
18        }
19        for(int i = 0 ; i < n ; i++){
20            arr[i] = map.get(arr[i]);
21        }
22        return arr;
23    }
24}