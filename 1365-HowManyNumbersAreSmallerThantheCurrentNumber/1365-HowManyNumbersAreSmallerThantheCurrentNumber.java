// Last updated: 7/21/2026, 1:07:23 AM
1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        List<Integer> ll= new ArrayList<>();
4        int max = 0;
5        Set<Integer> set = new HashSet<>();
6        for(int i = 0 ; i < nums.length ; i++) {
7            set.add(nums[i]);
8            max = Math.max(max,nums[i]);
9        }
10        int k = nums.length - set.size();
11        // for(int i = 1 ; i <= max ; i++){
12        //     if(!set.contains(i)) ll.add(i);
13        //     if(nums.length > set.size()+ll.size() && i == max){
14        //         ll.add(max+1);
15        //     }
16        // }
17        int c = 1;
18        while(k > 0){
19            if(!set.contains(c)){
20                ll.add(c);
21                k--;
22            }
23            c++;
24        }
25
26        return ll;
27    }
28}