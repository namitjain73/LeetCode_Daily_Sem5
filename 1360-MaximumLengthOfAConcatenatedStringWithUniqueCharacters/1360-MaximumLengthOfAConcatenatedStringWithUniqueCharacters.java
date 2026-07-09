// Last updated: 7/9/2026, 5:17:19 PM
class Solution {
    public int maxLength(List<String> arr) {
        Map<String,Integer> map = new HashMap<>();
       return solver(arr , 0 , "",map);
    }
    public int solver(List<String> arr, int i , String s , Map<String,Integer> map){
        if(i >= arr.size()) return s.length();
        if(map.containsKey(s)) return map.get(s);

        int ans = 0;
        if(noMatch(arr.get(i) , s)){
            ans = solver(arr , i+1 , s+arr.get(i),map);
        }
        ans = Math.max(ans,solver(arr , i + 1 , s,map));
        return ans;
    }
    public boolean noMatch(String s1, String s2){
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s2);
        int[] arr = new int[26];
        for(int i = 0 ; i < sb.length() ; i++){
            arr[sb.charAt(i)-'a']++;
            if(arr[sb.charAt(i)-'a'] > 1) return false;
        }
        return true;
    }
}