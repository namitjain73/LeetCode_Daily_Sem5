// Last updated: 7/9/2026, 5:00:16 PM
class Solution {
    private boolean[] prime;
    private void sieve(int n){
        prime=new boolean[n+1];
        Arrays.fill(prime,true); 
        prime[1]=false;
        for(int p=2;p*p<=n;p++) if(prime[p]) for(int i=p*p;i<=n;i+=p) prime[i]=false;
    }
    public int primeSubarray(int[] nums, int k) {
        int n=nums.length,max=0;
        for(int num:nums) max=Math.max(max,num);
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int primes=0,l1=0,l2=0;
        sieve(max);
        int cntK=0,cnt1=0;
        for(int r=0;r<n;r++){
            if(prime[nums[r]]){
                primes++;
                map.put(nums[r],map.getOrDefault(nums[r],0)+1); 
            }
            while(primes>1){
                if(prime[nums[l1]]) primes--;
                l1++;
            }
            while(!map.isEmpty()&&map.lastKey()-map.firstKey()>k){
                if(prime[nums[l2]]){
                    map.put(nums[l2],map.get(nums[l2])-1);
                    if(map.get(nums[l2])==0) map.remove(nums[l2]);
                }
                l2++;
            }
            cnt1+=(r-l1+1);
            cntK+=(r-l2+1);
        }
        return cntK-cnt1;
    }
}