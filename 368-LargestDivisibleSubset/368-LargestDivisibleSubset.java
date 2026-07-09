// Last updated: 7/9/2026, 5:22:11 PM
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int[] pre = new int[n];
        Arrays.fill(pre,-1);
        int max = 1;
        int lastidx = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] % nums[j] == 0){
                    if(arr[i] < arr[j]+1){
                        arr[i] = arr[j]+1;
                        pre[i] = j;
                    }
                    if(arr[i] > max){
                        max  =arr[i];
                        lastidx = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (lastidx != -1) {
            result.add(nums[lastidx]);
            lastidx = pre[lastidx];
        }
        
        return result;
       
    }
}