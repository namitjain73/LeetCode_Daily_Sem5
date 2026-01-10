// Last updated: 1/10/2026, 11:17:34 PM
1class Solution {
2
3    public int[] avoidFlood(int[] rains) {
4        int[] ans = new int[rains.length];
5        Arrays.fill(ans, 1);
6        TreeSet<Integer> st = new TreeSet<Integer>();
7        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
8        for (int i = 0; i < rains.length; ++i) {
9            if (rains[i] == 0) {
10                st.add(i);
11            } else {
12                ans[i] = -1;
13                if (mp.containsKey(rains[i])) {
14                    Integer it = st.ceiling(mp.get(rains[i]));
15                    if (it == null) {
16                        return new int[0];
17                    }
18                    ans[it] = rains[i];
19                    st.remove(it);
20                }
21                mp.put(rains[i], i);
22            }
23        }
24        return ans;
25    }
26}