// Last updated: 7/9/2026, 5:11:18 PM
class Solution {
    public int countHillValley(int[] nums) {
        int pre = nums[0];
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(pre);
        for(int i = 1 ; i < n ; i++){
            int curr = nums[i];
            if(curr != pre){
                list.add(curr);
                pre = curr;
            }
        }

        int hill = 0;
        int vally = 0;
        for(int i= 1 ; i < list.size()-1 ; i++){
            int a = list.get(i-1);
            int b = list.get(i);
            int c = list.get(i+1);
            if(a < b && b > c) hill++;
            else if(a > b && b < c) vally++;
        }

        return hill + vally;
    }
}