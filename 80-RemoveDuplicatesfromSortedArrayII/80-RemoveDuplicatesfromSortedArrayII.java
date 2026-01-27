// Last updated: 1/27/2026, 3:31:59 PM
1class Solution {
2    public int removeDuplicates(int[] nums) {
3        int n = nums.length;
4        int i = 1;
5        int c = 1;
6        int pre = nums[0];
7        for(int j = 1; j < n && i < n ; j++){
8            System.out.println(i + " " + j);
9            if(pre != nums[j]){
10                c=1;
11                pre = nums[j];
12            }
13            else if(c == 2){
14                continue;
15            }
16            else if(pre ==  nums[j]) {
17                c++;
18                // i++;
19            }
20
21         nums[i++] = nums[j];
22        }
23
24        // for(i = 0 ; i <n ; i++){
25        //     System.out.println(nums[i]);
26        // }
27        return i;
28    }
29}