// Last updated: 7/9/2026, 5:01:02 PM
class Solution {
    static boolean flag = false;
    public boolean checkEqualPartitions(int[] arr, long t) {
        flag = false;
		List<Integer> list = new ArrayList<>();
		rec(arr,t,1L,list,0);
		return flag;
        
        
    }
    
    public static void rec(int[] arr , long t ,long curr , List<Integer> ans , int idx){
        if(curr == t){
            // flag = true;
            // System.out.println(ans);
            if(itispossible(arr,ans,t)){
                flag = true;
            }
            return;
        }
        if(curr > t) return;

        for(int i = idx ; i < arr.length ; i++){
            int  n = arr[i];
            ans.add(n);
            curr *= n;
            rec(arr , t ,curr, ans , i+1);
            curr /= n;
            ans.remove(ans.size()-1);
        }
    }
    public static boolean itispossible(int[] arr , List<Integer> ans , long t){
        long curr = 1L;
        boolean f = false;
        for(int i = 0 ; i < arr.length ; i++){
            if(!ans.contains(arr[i])){
                curr *= arr[i];
                f = true;
                if (curr > t) return false;
            }
        }
        return f && curr == t;
    }
}