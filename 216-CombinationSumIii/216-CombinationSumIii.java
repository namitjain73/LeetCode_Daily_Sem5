// Last updated: 7/9/2026, 5:23:13 PM
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Print(n,k,list,ll,1,0);
        return ll;
    }

    public static void Print(int n , int k , List<Integer> list , List<List<Integer>> ll , int idx,int sum){
        if(list.size() == k && sum == n){
            ll.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx ; i <= 9 ; i++){
            if(list.size() < k){
                list.add(i);
                Print(n,k,list,ll,i+1,sum+i);
                list.remove(list.size()-1);
            }
        }
        return;
    }
    
}