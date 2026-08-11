// Last updated: 8/11/2026, 9:40:29 AM
1class Solution {
2    public int missingInteger(int[] nums) {
3        int miss = nums[0];
4        int pre = nums[0];
5        int sum = nums[0];
6        int len = 1;
7        int prelen = 0;
8        List<Integer> ll = new ArrayList<>();
9
10        for(int i = 1 ; i < nums.length ; i++){
11            if(pre+1 == nums[i]){
12                sum += nums[i];
13            }else break;
14
15            pre = nums[i];
16        }
17        for(int i : nums) ll.add(i);
18
19        while(ll.contains(sum)) {
20            sum++;
21        }
22
23        return sum;
24    }
25}