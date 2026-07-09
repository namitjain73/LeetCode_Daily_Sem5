// Last updated: 7/9/2026, 5:24:53 PM
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Print(n,k,list,ll,1);
        return ll;
    }

    public static void Print(int n , int k , List<Integer> list , List<List<Integer>> ll , int idx){
        if(list.size() == k){
            ll.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx ; i <= n ; i++){
            if(list.size() < k){
                list.add(i);
                Print(n,k,list,ll,i+1);
                list.remove(list.size()-1);
            }
        }
        return;
    }
    
}