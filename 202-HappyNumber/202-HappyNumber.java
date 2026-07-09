// Last updated: 7/9/2026, 5:23:28 PM
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = modify(n);
        }
        
        return n == 1;
        
    }

    public static int modify(int n){
        long sum = 0;
        while(n > 0){
            int rem = n % 10 ;
            n = n / 10;
            sum += (long)rem*rem;
        }
        return (int)sum;
    }
}