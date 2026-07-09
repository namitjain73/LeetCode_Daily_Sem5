// Last updated: 7/9/2026, 5:05:46 PM
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int a : apple){
            sum += a;
        }
        Arrays.sort(capacity);
        int right = capacity.length - 1;
        int boxes = 0;
        while(right >= 0){
            sum -= capacity[right];
            boxes++;
            if(sum <= 0){
                break;
            }
            right--;
        }
        return boxes;
    }
}