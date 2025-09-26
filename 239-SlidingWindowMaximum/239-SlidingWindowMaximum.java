// Last updated: 9/27/2025, 12:50:44 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int[] arr = new int[nums.length-k+1];
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            // step 1
            while(!d.isEmpty() && d.peekFirst() <= i-k){
                d.removeFirst();
            }

            // step2
            while(!d.isEmpty() && nums[i] > nums[d.peekLast()]){
                d.removeLast();
            }

            d.addLast(i);

            if(i >= k-1){
                arr[j++] = nums[d.peekFirst()];
            }
        }
        return arr;
    }
}