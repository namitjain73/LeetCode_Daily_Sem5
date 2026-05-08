// Last updated: 5/8/2026, 4:11:06 PM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3        List<Integer> list = new ArrayList<>();
4        Set<List<Integer>> set = new HashSet<>();
5        Arrays.sort(candidates);
6        solver(candidates , target , set , list , 0);
7        return new ArrayList<>(set);
8    }
9    public void solver(int[] arr , int t , Set<List<Integer>> set , List<Integer> list , int i){
10        if(t == 0){
11            set.add(new ArrayList<>(list));
12            return;
13        }
14        if(i >= arr.length) return;
15
16        for(int idx = i ; idx < arr.length ; idx++){
17            if(idx > i && arr[idx] == arr[idx-1]) continue;
18            if(t >= arr[idx]){
19                list.add(arr[idx]);
20                solver(arr , t-arr[idx] , set , list , idx+1);
21                list.remove(list.size()-1);
22            }
23        }
24    }
25}