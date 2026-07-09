// Last updated: 7/9/2026, 5:25:51 PM
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        return find(n,0,0,"",list);
    }
    public static List<String> find(int n,int open,int close,String ans,List<String> list){
        if(open == n && close == n){
            list.add(ans);
            return list;
        }
        if(close > open || open > n){
            return list;
        }
        
        find(n,open+1,close,ans+"(",list);
        find(n,open,close+1,ans+")",list);
        return list;
    }
}