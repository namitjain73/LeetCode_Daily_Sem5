// Last updated: 7/9/2026, 5:12:48 PM
class Solution {
    public int minOperations(int[][] grid, int x) {
        int ar[]=Arrays.stream(grid).flatMapToInt(Arrays::stream).sorted().toArray();
        int m=ar[ar.length/2];
        int t=0;
        for(int i:ar){
            int ms=Math.abs(i-m);
            if(ms%x!=0) return -1;
            t+=ms/x;
        }
        return t;
    }
}