// Last updated: 9/14/2026, 10:29:16 PM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        return (rec1[2] > rec2[0] && rec1[3] > rec2[1] &&
4                rec1[0] < rec2[2] && rec1[1] < rec2[3]);
5    }
6}