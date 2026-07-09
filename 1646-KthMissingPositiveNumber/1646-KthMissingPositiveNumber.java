// Last updated: 7/9/2026, 5:15:47 PM
class Solution {
    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i = 1 ; list.size() <= k ; i++){
            if(j < arr.length){
                if(arr[j] == i){
                    j++;
                }
                else{
                    list.add(i);
                }
            }
            else{
                list.add(i);
            }
            
        }
        return list.get(k-1);
        
    }
}