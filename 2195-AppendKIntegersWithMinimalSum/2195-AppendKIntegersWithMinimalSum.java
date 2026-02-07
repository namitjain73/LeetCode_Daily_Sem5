// Last updated: 2/7/2026, 11:04:26 PM
1class Solution {
2    public long minimalKSum(int[] nums, int k) {
3    Arrays.sort(nums);
4    Set<Integer> set = new HashSet<>();
5    long sum = 0;
6    for (int num: nums) {
7        if (!set.contains(num) && num<=k) {
8            k++;
9            sum += num;        
10        }            
11        set.add(num);
12    } 
13    long res = (long)(1 + k) * k / 2 - sum;
14    return res;             
15    }
16}