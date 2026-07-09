// Last updated: 7/9/2026, 5:13:23 PM
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        int n=patterns.length;
        for(int i =0 ;i<n;i++){
            if(word.contains(patterns[i])){
                ans++;
            }
        }
        return ans;
    }
}