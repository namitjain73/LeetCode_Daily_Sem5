// Last updated: 7/9/2026, 5:22:03 PM
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[] arr = new int[26];
        for(int  i = 0 ; i < n ; i++){
            arr[ch[i] - 'a'] += 1;
        }

        for(int  i = 0 ; i < n ; i++){
            if(arr[ch[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
        
    }
}