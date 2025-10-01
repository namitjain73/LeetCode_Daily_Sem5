// Last updated: 10/1/2025, 11:58:11 PM
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return room(intervals);
        
    }
    public static int room(int[][] arr) {
		Arrays.sort(arr , (a,b) -> Integer.compare(a[1],b[1]));
		int over = 0;
        int str = arr[0][0];
        int end = arr[0][1];
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i][0] < end){
                over++;
            }
            else{
                end = arr[i][1];
            }
        }
        return over;		
	}
}