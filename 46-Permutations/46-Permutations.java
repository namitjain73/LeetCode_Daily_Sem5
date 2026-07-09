// Last updated: 7/9/2026, 5:25:27 PM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Print(l,list,ll);
        return ll;
        
    }
    public static void Print(List<Integer> list,List<Integer> l,List<List<Integer>> ll){
        if(l.size() == 0){
            // System.out.println(list);
            ll.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0 ;  i < l.size() ; i++){
            list.add(l.get(i));
            int n = l.remove(i);
            Print(list,l,ll);
            // System.out.println(n);
           l.add(i,n);
           list.remove(list.size()-1);
             
        }
    }
}