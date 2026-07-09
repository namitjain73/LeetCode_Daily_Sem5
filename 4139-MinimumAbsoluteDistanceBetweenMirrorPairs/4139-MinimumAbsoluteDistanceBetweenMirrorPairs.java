// Last updated: 7/9/2026, 4:58:00 PM
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                minDist = Math.min(minDist, i - map.get(n));
            }
            int rev = reverse(n);
            map.put(rev, i);
            i++;
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private static int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}