// Last updated: 9/4/2025, 10:58:09 PM
class Solution {
    public int findClosest(int x, int y, int z) {
        int i = Math.abs(x-z);
        int j = Math.abs(y-z);

        if(i < j){
            return 1;
        }else if(j < i){
            return 2;
        }else{
            return 0;
        }
    }
}