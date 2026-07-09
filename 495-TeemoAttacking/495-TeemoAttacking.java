// Last updated: 7/9/2026, 5:21:17 PM
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;

        int sum = 0;
        for(int i = 0 ; i < timeSeries.length-1 ; i++){
            sum += Math.min(duration , timeSeries[i + 1] - timeSeries[i]);
        }
        return sum + duration;

        
        
    }
}