// Last updated: 12/5/2025, 11:35:14 PM
1class Solution {
2    public int[] findErrorNums(int[] nums) {
3        Arrays.sort(nums);
4        Set<Integer> set = new HashSet<Integer>();
5        for(int i = 0 ;i < nums.length ; i++){
6            set.add(nums[i]);
7        }
8        List<Integer> list2 = new ArrayList<>(set);
9        int n = nums[nums.length-1]+1;
10        for(int i = 1 ; i < list2.size() ; i++){
11            if(list2.get(i-1) != list2.get(i)-1){
12                n = list2.get(i)-1;
13                break;
14            }
15        }
16        if(nums[0] != 1){
17            n  = 1;
18        }
19        
20        List<Integer> list = new ArrayList<>();
21        int[] arr = new int[2];
22        int j = 0;
23        for(int i = 1 ; i < nums.length ; i++){
24            if(nums[i-1] == nums[i]){
25                j = nums[i];
26
27            }
28        }
29        arr[0] = j;
30        arr[1] = n;
31        return arr;
32
33        
34    }
35}