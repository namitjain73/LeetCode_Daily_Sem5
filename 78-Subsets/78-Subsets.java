// Last updated: 7/9/2026, 5:24:52 PM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        for(int i : nums){
            li.add(i);
        }
        
        Print(li , list , ll);
        return ll;
        
    }

    public static void Print(List<Integer> li , List<Integer> list, List<List<Integer>> ll){
        if(li.size() == 0){
            // list.sort(Comparator.naturalOrder());
            ll.add(new ArrayList<>(list));
            return;
        }
        
        int n = li.get(li.size()-1);
        int m = li.remove(li.size()-1);
        
        Print(li , list , ll);
        list.add(n);
        Print(li , list , ll);
        list.remove(list.size()-1);
        li.add(m);
        return ;
    }
}