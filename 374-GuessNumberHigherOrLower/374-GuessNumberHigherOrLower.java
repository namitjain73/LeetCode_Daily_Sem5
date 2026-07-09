// Last updated: 7/9/2026, 5:22:09 PM
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if (n == 1) return n;
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) < 0) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
        
    }
}