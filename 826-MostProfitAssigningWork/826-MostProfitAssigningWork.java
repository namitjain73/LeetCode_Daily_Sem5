// Last updated: 8/31/2025, 1:10:52 PM
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] prodiff = new int[profit.length][2];
        for(int i = 0 ; i < profit.length ; i++){
            prodiff[i][0] = profit[i];
            prodiff[i][1] = difficulty[i];
        }

        Arrays.sort(prodiff , (a,b) -> b[0] - a[0]);
        int c = 0;
        for(int work : worker){
            for(int i = 0 ; i < prodiff.length ; i++){
                if(prodiff[i][1] <= work){
                    c += prodiff[i][0];
                    System.out.println(prodiff[i][0]);
                    break;
                }
            }
        }
        return c;
    }
}