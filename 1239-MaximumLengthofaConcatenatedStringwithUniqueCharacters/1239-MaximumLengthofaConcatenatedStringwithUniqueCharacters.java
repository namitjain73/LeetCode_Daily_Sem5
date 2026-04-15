// Last updated: 4/16/2026, 12:55:32 AM
1class Solution {
2    public int maxLength(List<String> arr) {
3        Map<String,Integer> map = new HashMap<>();
4       return solver(arr , 0 , "",map);
5    }
6    public int solver(List<String> arr, int i , String s , Map<String,Integer> map){
7        if(i >= arr.size()) return s.length();
8        if(map.containsKey(s)) return map.get(s);
9
10        int ans = 0;
11        if(noMatch(arr.get(i) , s)){
12            ans = solver(arr , i+1 , s+arr.get(i),map);
13        }
14        ans = Math.max(ans,solver(arr , i + 1 , s,map));
15        return ans;
16    }
17    public boolean noMatch(String s1, String s2){
18        StringBuilder sb = new StringBuilder(s1);
19        sb.append(s2);
20        int[] arr = new int[26];
21        for(int i = 0 ; i < sb.length() ; i++){
22            arr[sb.charAt(i)-'a']++;
23            if(arr[sb.charAt(i)-'a'] > 1) return false;
24        }
25        return true;
26    }
27}