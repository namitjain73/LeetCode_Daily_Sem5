// Last updated: 6/8/2026, 12:40:17 PM
1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n = nums.length;
4        int[] arr = new int[n];
5        int k = 0;
6        Queue<Integer> q= new LinkedList<>();
7        int equal = 0;
8        for(int i = 0 ; i < n ; i++){
9            if(nums[i] == pivot) equal++;
10            else if(nums[i] > pivot) q.add(nums[i]);
11            else {
12                arr[k++] = nums[i];
13            }
14        }
15        while(equal-- > 0){
16            arr[k++] = pivot;
17        }
18        while(!q.isEmpty()){
19            arr[k++] = q.poll();
20        }
21        return arr;
22    }
23}