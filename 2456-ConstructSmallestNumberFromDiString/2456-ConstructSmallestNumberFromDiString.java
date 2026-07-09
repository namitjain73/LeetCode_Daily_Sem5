// Last updated: 7/9/2026, 5:10:00 PM
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] arr = new int[n+1];
        Stack<Integer> st = new Stack<>();
        int c = 1;

        for(int i = 0 ; i <= n ; i++){
            if(i == n || pattern.charAt(i) == 'I'){
                arr[i] = c;
                c++;
                while(!st.isEmpty()){
                    arr[st.pop()] =  c;
                    c++;
                }
            }else if(pattern.charAt(i) == 'D') st.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= n ; i++) sb.append(arr[i]);
        return sb.toString();
    }
}