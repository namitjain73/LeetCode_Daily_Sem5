// Last updated: 12/7/2025, 8:31:47 AM
1class Solution {
2    public int[] sortByReflection(int[] nums) {
3        for(int i= 0 ; i < nums.length ; i ++){
4            for(int j = i+1 ; j < nums.length ; j++){
5                int r1 = reflect(nums[i]);
6                int r2 = reflect(nums[j]);
7
8
9
10
11                if(r1 > r2 || r1 == r2 && nums[i] > nums[j]){
12                    int temp = nums[i];
13                    nums[i] = nums[j];
14                    nums[j] = temp;
15                }
16            }
17        }
18        return nums;
19    }
20
21    public int reflect(int n){
22        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
23        sb.reverse();
24        return Integer.parseInt(sb.toString(),2);
25    }
26}