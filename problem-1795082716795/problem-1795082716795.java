// Last updated: 11/19/2026, 3:35:16 PM
1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        Map<Integer,Integer> map = new HashMap<>();
4        for(int i = 0 ; i <nums.length; i++){
5            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
6        }
7        int x = map.size();
8        int[][] arr = new int[x][2];
9        int i = 0;
10        for(int key : map.keySet()){
11            arr[i][0] = key;
12            arr[i][1] = map.get(key);
13            i++;
14        }
15        Arrays.sort(arr, (a,b)->b[1]-a[1]);
16        int[] num = new int[k];
17        for(i = 0 ; i < k ; i++){
18            num[i] = arr[i][0];
19        }
20        return num;
21    }
22}