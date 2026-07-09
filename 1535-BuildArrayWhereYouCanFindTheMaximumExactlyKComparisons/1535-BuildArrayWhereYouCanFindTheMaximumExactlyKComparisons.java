// Last updated: 7/9/2026, 5:16:24 PM
import java.util.*;
class Solution {
    int N,M,K;
    int[][][] arr = new int[51][51][101];
    int mod = 1_000_000_007;
    public int helper(int idx , int search , int max){
        if(N == idx){
            if(search == K){
                return 1;
            }
            return 0;
        }

        if(arr[idx][search][max] != -1) return arr[idx][search][max];

        int result = 0;
        for(int i = 1 ; i <= M ; i++){
            if(i >  max){
                result = ( result + helper(idx + 1 , search  + 1 ,i)) % mod;
            }
            else result = (result + helper(idx + 1, search ,max)) % mod;
        }

        return arr[idx][search][max] = result %  mod;
    }
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                Arrays.fill(arr[i][j], -1);
            }
        }

        return helper(0,0,0);
    }
}