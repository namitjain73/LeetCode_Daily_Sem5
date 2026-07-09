// Last updated: 7/9/2026, 5:07:50 PM
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans= 0;

        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j ++){
                if(coprime(nums[i] , nums[j])){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean coprime(int a , int b){
        a = Integer.toString(a).charAt(0) - '0';
        b = b % 10;
        System.out.println(a+ " " + b);
        int con = Math.max(a,b);
        for(int i = 2 ; i <= con ; i++){
            if(a % i == 0 && b % i == 0){
                return false;
            }
        }
        return true;
    }
}