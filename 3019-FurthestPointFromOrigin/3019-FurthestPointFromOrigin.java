// Last updated: 7/9/2026, 5:07:09 PM
class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int lCount = 0;
        int rCount = 0;
        int underScoreCount = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'L') {
                lCount++;
            } else if (moves.charAt(i) == 'R') {
                rCount++;
            } else {
                underScoreCount++;
            }

        }

        return Math.abs(lCount - rCount) + underScoreCount;

    }
}