// Last updated: 7/9/2026, 5:02:22 PM
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> free = new ArrayList<>();
        free.add(startTime[0]);
        for(int i = 1; i < startTime.length ; i++){
            free.add(startTime[i] - endTime[i - 1]);
        }
        free.add(eventTime -  endTime[endTime.length-1]);

        int i = 0 ;
        int  j = 0 ;
        int maxsum = 0;
        int currsum = 0;
        int n = free.size();
        while(j < n){
            currsum += free.get(j);
            if(i < n && j-i+1 > k+1){
                currsum -= free.get(i);
                i++;
            }
            maxsum = Math.max(maxsum,currsum);
            j++;
        }
        return maxsum;

    }
}