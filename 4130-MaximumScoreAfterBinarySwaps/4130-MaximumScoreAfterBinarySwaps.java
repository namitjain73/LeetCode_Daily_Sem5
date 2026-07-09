// Last updated: 7/9/2026, 4:58:10 PM
class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length; 
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                list.add(i);
            }
        }
        if(list.size() == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0; long ans = 0;
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
            if(i == list.get(idx)){
                ans += pq.poll();
                idx++;
            }
            if(idx == list.size()){
                break;
            }
        }
        return ans;
    }
}