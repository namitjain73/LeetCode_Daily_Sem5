// Last updated: 1/4/2026, 11:16:16 PM
1class Solution {
2    int mod = 1000000007;
3    public int kConcatenationMaxSum(int[] arr, int k){
4        if(k==1) return Kadanes(arr);
5        long sum=0;
6        for(int i : arr) sum = (sum+i)%mod;
7        int newa[] = new int[arr.length*2];
8        for(int i=0;i<arr.length;i++) newa[i] = arr[i];
9        for(int i=0;i<arr.length;i++) newa[i+arr.length] = arr[i];
10        if(sum<=0) return Kadanes(newa);
11        return (Kadanes(newa) + (int)(((k-2)*sum)%mod))%mod;
12    }
13
14    public int Kadanes(int arr[]){
15        long ans=0;
16        long sum=0;
17        for(int i : arr){
18            sum+=i;
19            ans = Math.max(ans,sum);
20            if(sum<0) sum=0;     
21        }
22        return (int)ans%mod;
23    }
24}