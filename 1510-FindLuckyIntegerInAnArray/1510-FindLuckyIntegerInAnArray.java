// Last updated: 7/9/2026, 5:16:37 PM
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i] , 0) + 1);
        }

        int res = -1;
        for (int key : map.keySet()) {
        if (key == map.get(key)) {
            res = Math.max(res, key);
        }
    }

    return res;
        
    }
}