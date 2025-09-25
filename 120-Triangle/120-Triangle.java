// Last updated: 9/26/2025, 1:41:35 AM
class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        

        for(int i = t.size()-2 ; i >= 0 ; i--){
            for(int j = 0 ; j < t.get(i).size() ; j++){
                t.get(i).set(j,t.get(i).get(j)+Math.min(t.get(i+1).get(j),t.get(i+1).get(j+1)));
            }
        }
        return t.get(0).get(0);
    }
}