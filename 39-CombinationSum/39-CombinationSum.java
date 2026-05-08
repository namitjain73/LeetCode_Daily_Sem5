// Last updated: 5/8/2026, 3:57:12 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        Set<List<Integer>> set = new HashSet<>();
4        List<Integer> ll = new ArrayList<>();
5        List<List<Integer>> list = new ArrayList<>();
6        solver(candidates , target , set , ll, 0);
7        System.out.println(set);
8        return new ArrayList<>(set);
9    }
10    public void solver(int[] arr , int t , Set<List<Integer>> set , List<Integer> ll , int i){
11        if(t == 0){
12            System.out.println(ll);
13            // Collections.sort(ll);
14            set.add(new ArrayList<>(ll));
15            return;
16        }
17        if(i >= arr.length) return;
18
19        for(int idx = i ;  idx < arr.length ; idx++){
20            if(t >= arr[idx]){
21                ll.add(arr[idx]);
22                solver(arr , t-arr[idx] , set , ll , idx);
23                ll.remove(ll.size()-1);
24            }
25        }
26    }
27}