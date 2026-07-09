// Last updated: 7/9/2026, 5:18:38 PM
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int delete= 0;
        boolean[] ans = new boolean[n-1];
        for(int i = 0 ;i < m ; i++){
            boolean deletechar = false;
            for(int j = 0 ; j < n -1 ; j++){
                if(!ans[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                    deletechar = true;
                    break;
                }
            }
            if(deletechar){
                delete++;
                continue;
            }

            for(int j = 0 ; j < n -1 ; j++){
                if(!ans[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
                    ans[j] = true;
                }
            }
        }
        return delete;
    }
}