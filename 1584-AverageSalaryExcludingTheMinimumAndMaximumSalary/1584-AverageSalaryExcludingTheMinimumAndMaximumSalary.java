// Last updated: 7/9/2026, 5:16:04 PM
class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : salary){
            min = Math.min(min,i);
            max = Math.max(max,i);
            sum += i;
        }

        sum -= min;
        sum -= max;
        double ans = (double)(sum) / (double)(salary.length - 2);
        // double rounded = Math.round(ans * 100000.0) / 100000.0;
        return ans;
        
    }
}