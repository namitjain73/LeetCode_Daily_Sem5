// Last updated: 5/12/2026, 1:15:46 AM
1class Solution {
2    public int[] separateDigits(int[] nums) {
3        String s = "";
4        for(int i = 0; i < nums.length ; i++){
5            s += Integer.toString(nums[i]);
6        }
7
8        List<Integer> list = new ArrayList<>();
9        for(int i = 0 ; i < s.length() ;i++){
10            list.add(s.charAt(i) - '0');
11        }
12
13        int[] arr = new int[list.size()];
14        for(int i = 0 ; i < list.size(); i++){
15            arr[i] = list.get(i);
16        }
17        return arr;
18        
19    }
20}