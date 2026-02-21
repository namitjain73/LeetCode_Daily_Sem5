// Last updated: 2/21/2026, 10:25:22 PM
1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        boolean[] arr = new boolean[33];
4        arr[0] = true;
5        arr[1]= true;
6        for(int i = 2; i * i < arr.length; i++){    
7            if(arr[i]) continue;
8    
9            for(int j = i * i; j < arr.length; j += i){
10                arr[j] = true;
11            }
12        }
13        int ans = 0;
14        for(int i = left ; i<= right ; i++){
15            int setBit = Integer.bitCount(i);
16            System.out.println(setBit + " " + i + " " + arr[setBit]);
17            if(!arr[setBit]) ans++;
18        }
19        return ans;
20    }
21}