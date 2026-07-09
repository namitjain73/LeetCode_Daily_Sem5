// Last updated: 7/9/2026, 5:22:05 PM
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        rec(n,0,n,list);
        return list;
    }
    public static void rec(int n , int num , int curr,List<Integer> list){
        if(curr == 0){
            
            return;
        }
        if(num != 0){
            list.add(num);
        }

        int i = 0;
        if(num == 0){
            i = 1;
        }
        for(; i <= 9 ; i++){
            if(num*10+i <= n){
                rec(n , num*10+i , curr,list);
            }
        }
    }
}