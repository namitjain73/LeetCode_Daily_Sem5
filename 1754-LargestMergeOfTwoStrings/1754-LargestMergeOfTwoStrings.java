// Last updated: 1/19/2026, 3:45:47 PM
1class Solution {
2    public String largestMerge(String w1, String w2) {
3        StringBuilder sb = new StringBuilder();
4        int i = 0;
5        int j = 0;
6        int n = w1.length();
7        int m = w2.length();
8
9
10        while(i < n && j < m){
11            if(w1.substring(i).compareTo(w2.substring(j))>0){
12                sb.append(w1.charAt(i));
13                i++;
14            }else{
15                sb.append(w2.charAt(j));
16                j++;
17            }
18        }
19
20        if(i < n) sb.append(w1.substring(i));
21        if(j < m) sb.append(w2.substring(j));
22        return sb.toString();
23    }
24}