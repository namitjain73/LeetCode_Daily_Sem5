// Last updated: 7/9/2026, 5:06:24 PM
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int[][] freq = new int[26][n+1];
        int pre = s.charAt(0);
        freq[s.charAt(0)-'a'][1] = 1;
        int len = 1;

        for(int i = 1 ; i < n ; i++){
            int curr = s.charAt(i);
            if(pre == curr){
                len++;
                freq[curr-'a'][len]+=1;
            }else{
                len = 1;
                freq[curr-'a'][1] += 1;
                pre = curr;
            }
        }

        int ans = -1;
        for(int i = 0 ; i < 26 ; i++){
            int sum = 0;
            for(int j = n ; j >= 0 ; j--){
                sum += freq[i][j];
                if(sum >= 3){
                    ans = Math.max(ans,j);
                    break;
                }
            }
        }
        return ans;
    }
}