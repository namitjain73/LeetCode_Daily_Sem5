// Last updated: 5/8/2026, 3:58:07 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        Set<List<Integer>> set = new HashSet<>();
4        List<Integer> ll = new ArrayList<>();
5        List<List<Integer>> list = new ArrayList<>();
6        solver(candidates , target , set , ll, 0);
7        return new ArrayList<>(set);
8    }
9    public void solver(int[] arr , int t , Set<List<Integer>> set , List<Integer> ll , int i){
10        if(t == 0){
11            set.add(new ArrayList<>(ll));
12            return;
13        }
14        if(i >= arr.length) return;
15
16        for(int idx = i ;  idx < arr.length ; idx++){
17            if(t >= arr[idx]){
18                ll.add(arr[idx]);
19                solver(arr , t-arr[idx] , set , ll , idx);
20                ll.remove(ll.size()-1);
21            }
22        }
23    }
24}