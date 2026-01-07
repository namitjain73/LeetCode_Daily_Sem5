// Last updated: 1/7/2026, 10:33:45 PM
1class Solution {
2    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
3        
4
5        List<Integer> ll = new ArrayList<>();
6        int n= arr.length;
7        int[] pre = new int[n];
8        int[] suf = new int[n];
9
10        pre[0] = 0;
11        for(int i = 1 ; i < n ; i++){
12            if(arr[i] <= arr[i-1]) pre[i] = pre[i-1] + 1;
13        }
14        suf[n-1] = 0;
15        for(int i = n-2 ; i >= 0 ; i--){
16            if(arr[i] <= arr[i+1]) suf[i] = suf[i+1] + 1;
17        }
18
19        for(int i= time ;  i < n - time;  i++){
20            if(pre[i] >= time && suf[i] >= time){
21                ll.add(i);
22            }
23        }
24
25        return ll;
26
27    }
28}