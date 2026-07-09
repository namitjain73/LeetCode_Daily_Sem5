// Last updated: 7/9/2026, 5:20:12 PM
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ll = new ArrayList<>();
        for(int i = left ; i <= right ; i++){
            if(ispossible(i)){
                ll.add(i);
            }
        }
        return ll;
        
    }

    public static boolean ispossible(int n){
        int copy = n;
        while(n > 0){
            int rem = n % 10;
            n = n / 10;
            if(rem == 0 || copy % rem != 0) return false;
        }
        return true;
    }
}