// Last updated: 7/9/2026, 5:23:25 PM
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        return Count_Prime(n);
    }

    public static int Count_Prime(int n){
        int[] arr = new int[n];
        arr[0] = arr[1] = 1;
        for(int i = 2 ; i * i <= n ; i++){
            if(arr[i] == 0){
                for(int j = i * i ; j < n ; j+=i){
                    arr[j] = 1;
                }
            }
        }

        int x = 0;
        for(int i = 0 ; i  < n ; i++){
            if(arr[i] == 0) x+=1;
        }
        return x;

    }
}