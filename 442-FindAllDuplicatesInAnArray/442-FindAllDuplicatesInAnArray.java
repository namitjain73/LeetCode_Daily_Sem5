// Last updated: 7/9/2026, 5:21:35 PM
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int n  = arr.length;
        List<Integer> ll = new ArrayList<>();
        Arrays.sort(arr);
        int pre = arr[0];
        for(int i  =1 ; i < n ; i++){
            if(pre == arr[i]){
                if(i == n-1) ll.add(pre);
                else if(arr[i] == arr[i+1]){
                    i++;
                }else ll.add(arr[i]);
            }else{
                pre = arr[i];
            }
        }
        return ll;
    }
}