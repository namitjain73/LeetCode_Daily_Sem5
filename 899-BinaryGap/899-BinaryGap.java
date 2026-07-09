// Last updated: 7/9/2026, 5:19:07 PM
class Solution {
    public int binaryGap(int n) {
        int lastPosition = -1;
        int maxDistance = 0;
        int position = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, position - lastPosition);
                }
                lastPosition = position;
            }
            position++;
            n = n >> 1;
        }

        return maxDistance;
    }
}