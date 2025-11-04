// Last updated: 11/5/2025, 2:09:14 AM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int copy = x;
        int[] ans= new int[n - k +1];
        int z = 0;
        for(int i = 0 ; i < n-k+1 ; i++){
            x = copy;
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = i ; j < i+k ; j++){
                map.put(nums[j] , map.getOrDefault(nums[j],0)+1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });
            for(int key : map.keySet()){
                int[] arr = {key,map.get(key)};
                pq.add(arr);
            }
            int t = 0;
            while(!pq.isEmpty() && x-- > 0){
                int[] arr = pq.poll();
                t += arr[0] * arr[1];
            }
            ans[z++] = t;
        }
        return ans;
    }
}