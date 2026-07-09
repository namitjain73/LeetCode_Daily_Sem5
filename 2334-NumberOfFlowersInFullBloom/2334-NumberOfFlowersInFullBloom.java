// Last updated: 7/9/2026, 5:11:02 PM
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i =0 ; i < n ;i++){
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0 ;i < people.length ; i++){
            int x = upperbound(start, people[i]);
            int y = lowerbound(end , people[i]);
            people[i] = (x-y);
        }
        return people;
    }

    public static int upperbound(int[] start , int t){
        int lo = 0;
        int hi = start.length-1;
        int ans = start.length;
        while(lo <= hi){
            int mid = lo + ( hi - lo)/2;
            if(start[mid] > t){
                ans = mid;
                hi = mid - 1;
            }else{
                lo= mid + 1;
            }
        }
        return ans;
    }

    public static int lowerbound(int[] start , int t){
        int lo = 0;
        int hi = start.length-1;
        int ans = start.length;
        while(lo <= hi){
            int mid = lo + ( hi - lo)/2;
            if(start[mid] >= t){
                ans = mid;
                hi = mid - 1;
            }else{
                lo= mid + 1;
            }
        }
        return ans;
    }
}