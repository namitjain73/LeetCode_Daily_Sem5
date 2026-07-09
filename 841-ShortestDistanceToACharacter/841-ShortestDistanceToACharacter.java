// Last updated: 7/9/2026, 5:19:27 PM
class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == c) list.add(i);
        }

        int k = 0;
        int[] arr = new int[s.length()];

        int pre = Integer.MIN_VALUE/2;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == c) pre = i;
            arr[i] = i - pre;
        }
        pre = Integer.MAX_VALUE/2;
        for(int i =  s.length()-1; i >= 0; i--){
            if(s.charAt(i) == c) pre = i;
            arr[i] = Math.min(arr[i],pre-i);
        }
        return arr;
        
    }
}