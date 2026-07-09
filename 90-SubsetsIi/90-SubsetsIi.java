// Last updated: 7/9/2026, 5:24:41 PM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ll = new ArrayList<>();
        Arrays.sort(nums);
        
        Print(nums , list , ll,0);
        return ll;
        
    }

    public static void Print(int[] arr , List<Integer> list , List<List<Integer>> ll , int idx){
            ll.add(new ArrayList<>(list));

            for(int i = idx ;  i < arr.length ; i++){
                if(i > idx && arr[i-1] == arr[i]) continue;

                list.add(arr[i]);
                Print(arr,list,ll,i+1);
                list.remove(list.size()-1);
            }

        return;
        
    }
}