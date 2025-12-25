// Last updated: 12/25/2025, 11:16:24 PM
1class Solution {
2    public long makeSubKSumEqual(int[] arr, int k) {
3        long opr=0;
4        boolean visited[] = new boolean[arr.length];
5        for(int i=0;i<arr.length;i++){
6            if(visited[i]){
7                continue;
8            }
9            List<Integer>list = new ArrayList<>();
10            int j=i;
11            while(!visited[j]){
12                list.add(arr[j]);
13                visited[j]=true;
14                j = (j+k)%arr.length;
15            }
16            Collections.sort(list);
17            int median = list.get(list.size()/2);
18
19            for(int h : list){
20                opr+=Math.abs(h-median);
21            }
22        }
23        return opr;
24    }
25}