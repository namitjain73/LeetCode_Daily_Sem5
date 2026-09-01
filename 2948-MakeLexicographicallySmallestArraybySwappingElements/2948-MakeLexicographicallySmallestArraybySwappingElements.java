// Last updated: 9/1/2026, 2:12:15 PM
1class Solution {
2    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
3        int n = nums.length;
4
5        int[] sorted = nums.clone();
6        Arrays.sort(sorted);
7
8        Map<Integer, List<Integer>> group = new HashMap<>();
9        Map<Integer, Integer> groupId = new HashMap<>();
10        Map<Integer, Integer> pos = new HashMap<>();
11
12        int id = 1;
13        group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[0]);
14        groupId.put(sorted[0], id);
15
16        for(int i = 1; i < n; i++){
17            if(sorted[i] - sorted[i - 1] > limit){
18                id++;
19            }
20
21            group.computeIfAbsent(id, k -> new ArrayList<>()).add(sorted[i]);
22            groupId.put(sorted[i], id);
23        }
24        for(int i = 0; i < n; i++){
25            int grp = groupId.get(nums[i]);
26            int p = pos.getOrDefault(grp, 0);
27
28            nums[i] = group.get(grp).get(p);
29            pos.put(grp, p + 1);
30        }
31
32        return nums;
33    }
34}