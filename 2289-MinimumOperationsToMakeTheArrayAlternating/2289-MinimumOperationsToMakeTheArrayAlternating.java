// Last updated: 7/9/2026, 5:11:41 PM
class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> freq1 =  new HashMap<>();
        HashMap<Integer,Integer> freq2 =  new HashMap<>();
        int n = nums.length;
        int a = 0;
        int b = 0;
        int max_a = 0;
        int pre_a= 0;
        int max_b = 0;
        int pre_b = 0;

        int ans= Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                freq1.put(nums[i] , freq1.getOrDefault(nums[i],0)+1);
            }
            else {
                freq2.put(nums[i] , freq2.getOrDefault(nums[i],0)+1);
            }
            
        }

        for(int i : freq1.keySet()){
            if(max_a <= freq1.get(i)){
                pre_a = max_a;
                max_a = freq1.get(i);
                a = i;
            }else if(freq1.get(i) < max_a && freq1.get(i) > pre_a){
                pre_a = freq1.get(i);
            }
        }

        for(int i : freq2.keySet()){
            if(max_b <= freq2.get(i)){
                pre_b = max_b;
                max_b = freq2.get(i);
                b = i;
            }else if(freq2.get(i) < max_b && freq2.get(i) > pre_b){
                pre_b = freq2.get(i);
            }

            if(a == b){
                ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
            }else{
                ans = Math.min(ans, n - (max_a+max_b));
            }
        }
        if(a == b){
            ans = Math.min(ans,n - (Math.max(max_a+pre_b , max_b+pre_a)));
        }else{
            ans = Math.min(ans, n - (max_a+max_b));
        }


        return ans;
    }
}