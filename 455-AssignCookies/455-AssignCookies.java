// Last updated: 10/2/2025, 1:54:40 PM
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c= 0;
        int j = 0;
        for(int i = 0 ; i < g.length ;i++){
            while(j < s.length && s[j] < g[i]){
                j++;
            }
            if(j == s.length) return c;

            j++;
            c++;
        }
        return c;
        
    }
}