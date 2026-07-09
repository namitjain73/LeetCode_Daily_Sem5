// Last updated: 7/9/2026, 5:20:14 PM
class Solution {
    public int pivotIndex(int[] nums) {
        int[] presum = presum(nums);
        int[] postsum = posrsum(nums);

        for(int i = 0 ; i < nums.length ; i++){
            if(presum[i] == postsum[i]){
                return i;
            }
        }
        return -1;
        
    }
    public int[] presum(int[] arr){
        int[] pre = new int[arr.length];
        pre[0] = arr[0];
        for(int i = 1 ; i < arr.length ;i++){
            pre[i] = pre[i-1]+arr[i];
        }
        return pre;
    }
    public int[] posrsum(int[] arr){
        int n = arr.length;
        int[] post = new int[n];
        post[n - 1] = arr[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            post[i] = post[i + 1] + arr[i];
        }
        return post;
    }
}