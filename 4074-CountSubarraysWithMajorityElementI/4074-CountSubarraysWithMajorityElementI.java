// Last updated: 7/9/2026, 4:58:22 PM
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int balance = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int res = 0;
        int curr = 0;
        for (int x : nums) {
            if (x == target) {
                curr += cnt.getOrDefault(balance, 0);
                balance++;
            } else {
                balance--;
                curr -= cnt.getOrDefault(balance, 0);
            }
            cnt.put(balance, cnt.getOrDefault(balance, 0) + 1);
            res += curr;
        }
        return res;
    }
}