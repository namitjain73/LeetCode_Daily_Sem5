// Last updated: 7/9/2026, 4:59:03 PM
class Solution {
    public int[] recoverOrder(int[] o, int[] f) {
        int[] arr = new int[f.length];
        int j = 0;
        for(int i = 0 ;  i < o.length ; i++){
            if(ispresent(o[i],f)){
                arr[j] = o[i];
                j++;
            }
        }
        return arr;
    }
    public boolean ispresent(int j , int[] arr){
        for(int i : arr){
            if(i == j) return true;
        }
        return false;
    }
}