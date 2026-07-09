// Last updated: 7/9/2026, 4:59:51 PM
class Solution {
    public int minSensors(int n, int m, int k) {
        int b = 2*k+1;
        int r=(n+b-1)/b;
        int c = (m+b-1)/b;
        return r*c;
    }
}