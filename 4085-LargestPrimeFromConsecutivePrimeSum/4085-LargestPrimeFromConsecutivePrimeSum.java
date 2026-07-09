// Last updated: 7/9/2026, 4:58:18 PM
class Solution {
    public int largestPrime(int n) {
        int  ans = 0;
        int[] arr = solver(n);
        arr[0] = 1;
        arr[1] =1;
        List<Integer> ll = new ArrayList<>();
        for(int i = 2  ; i <= n ; i++){
            if(arr[i] == 0){
                ll.add(i);
            }
        }


        // for(int i = 0 ;i < ll.size() ; i++){
        //     int sum = 0;
        //     for(int j = i ;  j< ll.size() ; j++){
        //         sum += ll.get(j);

        //         if(sum > n) break;

        //         if(arr[sum] == 0){
        //             ans = Math.max(ans , sum);
        //         }
        //     }
        // }
        // int ans = 0;
        int sum = 0;
        for(int i = 2 ; i <= n && sum <= n; i++){
            if(arr[i] == 0){
                sum += i;
                if(sum <= n && arr[sum] == 0){
                    ans = sum;
                }
            }
        }
        return ans;
    }
    public int[] solver(int n){
        int[] arr= new int[n+1];
        for(int i = 2 ;i * i <= n ; i++){
            if(arr[i] == 0) for(int j = i*i ; j <= n ; j+=i){
                arr[j] = 1;
            }
        }
        // Syst
        return arr;
    }
}