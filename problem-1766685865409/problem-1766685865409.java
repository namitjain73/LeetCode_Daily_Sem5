// Last updated: 12/25/2025, 11:34:25 PM
1class Solution { 
2public int countNicePairs(int[] nums) {
3    int finalCount = 0;
4    int mod = (int)Math.pow(10,9) + 7;
5    Map<Integer,Integer> map = new HashMap<>();
6    for(int i = 0; i < nums.length; i++){
7        int element = nums[i] - rev(nums[i]);
8        if(!map.containsKey(element)){
9            map.put(element,1);
10        }else{
11            int repeatCount = map.get(element);
12            map.put(element , repeatCount + 1);
13            finalCount = (finalCount + repeatCount) % mod;
14        }
15    }
16    return finalCount;
17}
18private int rev(int i) {
19    int res = 0;
20    while (i > 0) {
21      res = res * 10 + i % 10;
22      i /= 10;
23    }
24    return res;
25}
26}