// Last updated: 7/9/2026, 5:18:53 PM
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int i = 0 ;
        int j = 0 ;
        int n = fruits.length;
        while(j < n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            if(map.size() <= 2){
                max = Math.max(max, j - i + 1);
            }else{
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);
                if(map.get(fruits[i]) == 0) map.remove(fruits[i]);
                i++;
            }
            j++;
        }
        return max;
    }
}