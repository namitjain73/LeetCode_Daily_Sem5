// Last updated: 7/9/2026, 5:11:46 PM
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] arr = new int[n];
        int k = 0;
        Queue<Integer> q= new LinkedList<>();
        int equal = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == pivot) equal++;
            else if(nums[i] > pivot) q.add(nums[i]);
            else {
                arr[k++] = nums[i];
            }
        }
        while(equal-- > 0){
            arr[k++] = pivot;
        }
        while(!q.isEmpty()){
            arr[k++] = q.poll();
        }
        return arr;
    }
}