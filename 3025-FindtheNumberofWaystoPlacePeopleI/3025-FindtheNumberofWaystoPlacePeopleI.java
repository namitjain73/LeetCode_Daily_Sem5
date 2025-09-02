// Last updated: 9/3/2025, 1:45:05 AM
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(!((x2 >= x1 && y2 <= y1) || (x1 >= x2 && y2 >= y1))) continue;
                boolean flag = true;
                for(int k=0; k<n; k++){
                    if(k == i || k==j) continue;
                    int x = points[k][0];
                    int y = points[k][1];
                    if((x <= Math.max(x1,x2) && x>= Math.min(x1,x2)) && (y <= Math.max(y1,y2) && y>= Math.min(y1,y2)))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count++;
                } 
            }
        }
        return count;
    }
}