// Last updated: 1/12/2026, 11:32:48 PM
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
17                // if(a <= freq1.get(nums[i]) ){
18                //     pre_a = a;
19                //     a = freq1.get(nums[i]);
20                //     max_a = nums[i];
21                // }
22            }
23            else {
24                freq2.put(nums[i] , freq2.getOrDefault(nums[i],0)+1);
25                // if(b <= freq2.get(nums[i])){
26                //     pre_b = b;
27                //     b = freq2.get(nums[i]);
28                //     max_b = nums[i];
29                // }
30            }
31            // System.out.println(max_a +" " + pre_a + " " + max_b+" " + pre_b);
32            // if(max_a != max_b){
33            //     ans = Math.min(ans , n - (a+b));
34            // }else{
35            //     ans = Math.min(ans , n - (pre_a+pre_b));
36            // }
37        }
38
39        for(int i : freq1.keySet()){
40            if(max_a <= freq1.get(i)){
41                pre_a = max_a;
42                max_a = freq1.get(i);
43                a = i;
44            }else if(freq1.get(i) < max_a && freq1.get(i) > pre_a){
45                pre_a = freq1.get(i);
46            }
47        }
48
49        for(int i : freq2.keySet()){
50            if(max_b <= freq2.get(i)){
51                pre_b = max_b;
52                max_b = freq2.get(i);
53                b = i;
54            }else if(freq2.get(i) < max_b && freq2.get(i) > pre_b){
55                pre_b = freq2.get(i);
56            }
57
58            if(a == b){
59                ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
60            }else{
61                ans = Math.min(ans, n - (max_a+max_b));
62            }
63        }
64        if(a == b){
65            ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
66        }else{
67            ans = Math.min(ans, n - (max_a+max_b));
68        }
69
70
71        return ans;
72    }
73}