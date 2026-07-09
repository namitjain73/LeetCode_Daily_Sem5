// Last updated: 7/9/2026, 5:05:43 PM
class Solution {
    public int maxBottlesDrunk(int n, int e) {
        int Db = 0;
        int empty = 0;
        Db += n;
        empty += n;
        n = 0;

        while(empty >= e || n >= e){
            while(empty >= e){
                empty -= e;
                n++;
                e++;
            }
            Db += n;
            empty += n;
            n = 0;
        }
        return Db;
        
    }
}