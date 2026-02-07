// Last updated: 2/7/2026, 11:07:05 PM
1class Solution {
2    public int minimumOperations(int[] nums) {
3        HashMap<Integer,Integer> freq1 =  new HashMap<>();
4        HashMap<Integer,Integer> freq2 =  new HashMap<>();
5        int n = nums.length;
6        int a = 0;
7        int b = 0;
8        int max_a = 0;
9        int pre_a= 0;
10        int max_b = 0;
11        int pre_b = 0;
12
13        int ans= Integer.MAX_VALUE;
14        for(int i = 0 ; i < n ; i++){
15            if(i % 2 == 0){
16                freq1.put(nums[i] , freq1.getOrDefault(nums[i],0)+1);
17            }
18            else {
19                freq2.put(nums[i] , freq2.getOrDefault(nums[i],0)+1);
20            }
21            
22        }
23
24        for(int i : freq1.keySet()){
25            if(max_a <= freq1.get(i)){
26                pre_a = max_a;
27                max_a = freq1.get(i);
28                a = i;
29            }else if(freq1.get(i) < max_a && freq1.get(i) > pre_a){
30                pre_a = freq1.get(i);
31            }
32        }
33
34        for(int i : freq2.keySet()){
35            if(max_b <= freq2.get(i)){
36                pre_b = max_b;
37                max_b = freq2.get(i);
38                b = i;
39            }else if(freq2.get(i) < max_b && freq2.get(i) > pre_b){
40                pre_b = freq2.get(i);
41            }
42
43            if(a == b){
44                ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
45            }else{
46                ans = Math.min(ans, n - (max_a+max_b));
47            }
48        }
49        if(a == b){
50            ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
51        }else{
52            ans = Math.min(ans, n - (max_a+max_b));
53        }
54
55
56        return ans;
57    }
58}