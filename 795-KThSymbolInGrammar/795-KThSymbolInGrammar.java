// Last updated: 7/9/2026, 5:19:42 PM
class Solution {
    public int kthGrammar(int n, int k) {
        return rec(n,k);
        
    }

    public int rec(int n, int k){
        if(n == 1 && k == 1){
            return 0;
        }

        int len  = (int)Math.pow(2,n-1);
        int mid = len/2;
        if(k <= mid){
            return rec(n-1,k);
        }
        else{
            return 1-rec(n-1 , k-mid);
        }
    }
}