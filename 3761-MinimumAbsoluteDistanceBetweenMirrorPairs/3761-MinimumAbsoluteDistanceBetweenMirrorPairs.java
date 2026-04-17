// Last updated: 4/18/2026, 1:41:51 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int minDist = Integer.MAX_VALUE;
4        Map<Integer, Integer> map = new HashMap<>();
5        int i = 0;
6        for (int n : nums) {
7            if (map.containsKey(n)) {
8                minDist = Math.min(minDist, i - map.get(n));
9            }
10            int rev = reverse(n);
11            map.put(rev, i);
12            i++;
13        }
14        return minDist == Integer.MAX_VALUE ? -1 : minDist;
15    }
16    private static int reverse(int num) {
17        int rev = 0;
18        while (num > 0) {
19            rev = rev * 10 + num % 10;
20            num /= 10;
21        }
22        return rev;
23    }
24}