// Last updated: 7/16/2026, 3:35:38 PM
1class Solution {
2    public long gcdSum(int[] nums) {
3        int n = nums.length;
4        int[] mx = new int[n];
5        mx[0] = nums[0];
6        for(int i = 1 ; i < n ; i++){
7            mx[i] = Math.max(nums[i] , mx[i-1]);
8        }
9
10        int[] prefixGcd = prefixGcd(mx,nums);
11        Arrays.sort(prefixGcd);
12        long sum = 0;
13        int i = 0;
14        int j = n-1;
15        while(i < j){
16            sum += gcd(prefixGcd[i],prefixGcd[j]);
17            i++;
18            j--;
19        }
20        return sum;
21    }
22    public int[] prefixGcd(int[] mx , int[] arr){
23        int n = arr.length;
24        for(int i = 0 ; i < n ; i++){
25            mx[i] = gcd(mx[i],arr[i]);
26        }
27        return mx;
28    }
29    public int gcd(int a , int b){
30        if(b == 0) return a;
31        return gcd(b , a%b);
32    }
33}