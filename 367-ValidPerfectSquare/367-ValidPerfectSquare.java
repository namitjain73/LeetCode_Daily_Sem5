// Last updated: 9/27/2025, 11:41:04 PM
class Solution {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int)Math.sqrt(num);
        return sqrt*sqrt == num;
    }
}