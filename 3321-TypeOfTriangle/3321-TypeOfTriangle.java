// Last updated: 7/9/2026, 5:05:52 PM
class Solution {
    public String triangleType(int[] nums) {
        int i = nums[0], j = nums[1], k = nums[2];
        if (i + j <= k || i + k <= j || j + k <= i) {
            return "none";
        }
        if (i == j && j == k) return "equilateral";
        else if (i == j || i == k || j == k) return "isosceles";
        else return "scalene";
    }
}
