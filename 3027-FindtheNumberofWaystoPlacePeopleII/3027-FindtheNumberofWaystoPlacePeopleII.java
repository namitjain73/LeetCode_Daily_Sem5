// Last updated: 9/4/2025, 1:57:32 AM
class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b)-> a[0] == b[0] ? b[1]-a[1] : a[0]- b[0]);
        int result = 0;
        int n = points.length;
        for(int i = 0 ; i < n ; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int maxy = Integer.MIN_VALUE;
            for(int j = i+1 ; j < n ; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(y2 > y1) continue;
                if(maxy < y2){
                    result++;
                    maxy = y2;
                }
            }
        }
        return result;
    }
}