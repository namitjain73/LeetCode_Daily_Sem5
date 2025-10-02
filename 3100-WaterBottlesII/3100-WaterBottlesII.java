// Last updated: 10/2/2025, 1:14:53 PM
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