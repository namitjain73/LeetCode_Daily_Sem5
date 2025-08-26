// Last updated: 8/26/2025, 5:07:14 PM
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