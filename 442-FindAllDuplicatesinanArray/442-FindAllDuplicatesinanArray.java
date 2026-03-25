// Last updated: 3/26/2026, 1:13:47 AM
1class Solution {
2    public List<Integer> findDuplicates(int[] arr) {
3        int n  = arr.length;
4        List<Integer> ll = new ArrayList<>();
5        Arrays.sort(arr);
6        int pre = arr[0];
7        for(int i  =1 ; i < n ; i++){
8            if(pre == arr[i]){
9                if(i == n-1) ll.add(pre);
10                else if(arr[i] == arr[i+1]){
11                    i++;
12                }else ll.add(arr[i]);
13            }else{
14                pre = arr[i];
15            }
16        }
17        return ll;
18    }
19}