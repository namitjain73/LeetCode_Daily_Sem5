// Last updated: 7/9/2026, 5:12:19 PM
class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        

        List<Integer> ll = new ArrayList<>();
        int n= arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = 0;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] <= arr[i-1]) pre[i] = pre[i-1] + 1;
        }
        suf[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--){
            if(arr[i] <= arr[i+1]) suf[i] = suf[i+1] + 1;
        }

        for(int i= time ;  i < n - time;  i++){
            if(pre[i] >= time && suf[i] >= time){
                ll.add(i);
            }
        }

        return ll;

    }
}