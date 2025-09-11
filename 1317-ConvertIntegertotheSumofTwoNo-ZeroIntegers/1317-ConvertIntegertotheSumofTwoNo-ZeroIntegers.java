// Last updated: 9/12/2025, 3:15:30 AM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];
        for(int i = 1 ; i < n ; i++){
            int a = i;
            int b = n-i;
            if(cheack(a,b)){
                arr[0] = a;
                arr[1] = b;
                break;
            }
        }
        return arr;
        
    }
    public boolean cheack(int a , int b){
        while(a > 0){
            int rem = a % 10;
            a = a / 10;
            if(rem == 0) return false;
        }
        while(b > 0){
            int rem = b % 10;
            b = b / 10;
            if(rem == 0) return false;
        }
        return true;
    }
}