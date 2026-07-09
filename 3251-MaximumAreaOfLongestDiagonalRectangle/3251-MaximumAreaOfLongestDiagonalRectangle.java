// Last updated: 7/9/2026, 5:06:32 PM
class Solution {
    public int areaOfMaxDiagonal(int[][] arr) {

        double max = 0.0;
        int res = 0;
        int n = arr.length;
        for(int[] ar : arr){
            int l = ar[0];
            int r = ar[1];
            double d = Math.sqrt(l*l+r*r);
            if(max < d){
                max = d;
                res = l*r;
            }else if(d == max){
                res = Math.max(res,l*r);
            }
        }
        return res;
        
    }
}