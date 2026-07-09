// Last updated: 7/9/2026, 5:16:36 PM
class Solution {
    public int numTeams(int[] arr) {
        int ans = 0;

        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1;  j < n ; j++){
                for(int k = j+1 ; k < n ; k++){
                    if((arr[i] < arr[j] && arr[j] < arr[k]) || (arr[i] > arr[j]&& arr[j] >arr[k])) ans++;
                }
            }
        }
        return ans;
    }
}