// Last updated: 7/9/2026, 5:25:14 PM
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        for(; i < n ; i++){
            if(intervals[i][1] < newInterval[0]){
                result.add(intervals[i]);
            }else if(intervals[i][0] > newInterval[1]) break;
            else {
                newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            }
        }
        result.add(newInterval);
        for(; i < n ; i++){
            result.add(intervals[i]);
        }

        int[][] arr = new int[result.size()][2];
        int j = 0;
        for(int[] idx : result){
            arr[j++] = idx;
        }
        return arr;
    }
}