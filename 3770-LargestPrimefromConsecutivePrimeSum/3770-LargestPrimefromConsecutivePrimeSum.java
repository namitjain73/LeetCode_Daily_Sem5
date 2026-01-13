// Last updated: 1/13/2026, 1:22:19 PM
1class Solution {
2    public int largestPrime(int n) {
3        int  ans = 0;
4        int[] arr = solver(n);
5        arr[0] = 1;
6        arr[1] =1;
7        List<Integer> ll = new ArrayList<>();
8        for(int i = 2  ; i <= n ; i++){
9            if(arr[i] == 0){
10                ll.add(i);
11            }
12        }
13
14
15        // for(int i = 0 ;i < ll.size() ; i++){
16        //     int sum = 0;
17        //     for(int j = i ;  j< ll.size() ; j++){
18        //         sum += ll.get(j);
19
20        //         if(sum > n) break;
21
22        //         if(arr[sum] == 0){
23        //             ans = Math.max(ans , sum);
24        //         }
25        //     }
26        // }
27        // int ans = 0;
28        int sum = 0;
29        for(int i = 2 ; i <= n && sum <= n; i++){
30            if(arr[i] == 0){
31                sum += i;
32                if(sum <= n && arr[sum] == 0){
33                    ans = sum;
34                }
35            }
36        }
37        return ans;
38    }
39    public int[] solver(int n){
40        int[] arr= new int[n+1];
41        for(int i = 2 ;i * i <= n ; i++){
42            if(arr[i] == 0) for(int j = i*i ; j <= n ; j+=i){
43                arr[j] = 1;
44            }
45        }
46        // Syst
47        return arr;
48    }
49}