// Last updated: 7/9/2026, 5:25:35 PM
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        solver(candidates , target , set , list , 0);
        return new ArrayList<>(set);
    }
    public void solver(int[] arr , int t , Set<List<Integer>> set , List<Integer> list , int i){
        if(t == 0){
            set.add(new ArrayList<>(list));
            return;
        }
        if(i >= arr.length) return;

        for(int idx = i ; idx < arr.length ; idx++){
            if(idx > i && arr[idx] == arr[idx-1]) continue;
            if(t >= arr[idx]){
                list.add(arr[idx]);
                solver(arr , t-arr[idx] , set , list , idx+1);
                list.remove(list.size()-1);
            }
        }
    }
}