// Last updated: 1/12/2026, 11:53:10 PM
1class Solution {
2    public int longestBalanced(int[] nums) {
3        int ans=0;
4        int n=nums.length;
5        Set<Integer> odd,even;
6        for(int i=0;i<n;i++){
7            odd=new HashSet<>();
8            even=new HashSet<>();
9            for(int j=i;j<n;j++){
10                if(nums[j]%2==0){
11                    even.add(nums[j]);
12                }else{
13                    odd.add(nums[j]);
14                }
15                if(even.size()==odd.size()){
16                    ans=Math.max(ans,j-i+1);
17                }
18            }
19        }
20        return ans;
21    }
22}