// Last updated: 1/23/2026, 1:33:51 AM
1class Solution {
2    public int minimumPairRemoval(int[] nums) {
3        List<Integer> arr = new ArrayList<>();
4        for (int num : nums) {
5            arr.add(num);
6        }
7        
8        int operations = 0;
9        
10        while (true) {
11            boolean isSorted = true;
12            for (int i = 0; i < arr.size() - 1; i++) {
13                if (arr.get(i) > arr.get(i + 1)) {
14                    isSorted = false;
15                    break;
16                }
17            }
18            
19            if (isSorted) {
20                return operations;
21            }
22            int minSum = Integer.MAX_VALUE;
23            int index = -1;
24            
25            for (int i = 0; i < arr.size() - 1; i++) {
26                int sum = arr.get(i) + arr.get(i + 1);
27                if (sum < minSum) {
28                    minSum = sum;
29                    index = i;
30                }
31            }
32            arr.set(index, minSum);
33            arr.remove(index + 1);
34            
35            operations++;
36        }
37    }
38}