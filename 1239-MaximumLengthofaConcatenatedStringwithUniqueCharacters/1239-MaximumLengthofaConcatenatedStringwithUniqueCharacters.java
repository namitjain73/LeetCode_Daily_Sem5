// Last updated: 4/16/2026, 12:43:31 AM
1class Solution {
2    public int maxLength(List<String> arr) {
3        return solver(arr , 0 , "");
4    }
5    public int solver(List<String> arr, int i , String s){
6        if(i >= arr.size()) return s.length();
7
8        int ans = 0;
9        if(noMatch(arr.get(i) , s)){
10            ans = solver(arr , i+1 , s+arr.get(i));
11        }
12        ans = Math.max(ans,solver(arr , i + 1 , s));
13        return ans;
14    }
15    public boolean noMatch(String s1, String s2){
16        StringBuilder sb = new StringBuilder(s1);
17        sb.append(s2);
18        int[] arr = new int[26];
19        for(int i = 0 ; i < sb.length() ; i++){
20            arr[sb.charAt(i)-'a']++;
21            if(arr[sb.charAt(i)-'a'] > 1) return false;
22        }
23        return true;
24    }
25}