// Last updated: 7/9/2026, 5:18:01 PM
class Solution {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        return solver(nums1, nums2, 0, 0, dp);
    }

    public int solver(int[] nums1, int[] nums2,int i, int j, int[][] dp) {
        if(i == nums1.length || j == nums2.length) return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        int skip = 0;
        if(nums1[i] == nums2[j]) {

            take = 1 + solver(nums1, nums2,
                              i + 1, j + 1, dp);

        } else {
            skip = Math.max(
                    solver(nums1, nums2, i + 1, j, dp),
                    solver(nums1, nums2, i, j + 1, dp)
            );
        }

        return dp[i][j] = Math.max(take, skip);
    }
}