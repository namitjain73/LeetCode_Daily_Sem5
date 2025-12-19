// Last updated: 12/19/2025, 10:53:50 PM
1class Solution {
2    public boolean isPossible(int[] nums) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        Map<Integer, Integer> end = new HashMap<>();
5        for (int num : nums) {
6            freq.put(num, freq.getOrDefault(num, 0) + 1);
7        }
8
9        for (int num : nums) {
10            if (freq.get(num) == 0) continue;
11            if (end.getOrDefault(num - 1, 0) > 0) {
12                end.put(num - 1, end.get(num - 1) - 1);
13                end.put(num, end.getOrDefault(num, 0) + 1);
14            }
15            else if (freq.getOrDefault(num + 1, 0) > 0 &&
16                     freq.getOrDefault(num + 2, 0) > 0) {
17                freq.put(num + 1, freq.get(num + 1) - 1);
18                freq.put(num + 2, freq.get(num + 2) - 1);
19                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
20            }
21            else {
22                return false;
23            }
24
25            freq.put(num, freq.get(num) - 1);
26        }
27
28        return true;
29    }
30}
31