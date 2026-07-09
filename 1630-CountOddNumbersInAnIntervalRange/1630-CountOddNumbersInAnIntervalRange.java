// Last updated: 7/9/2026, 5:15:55 PM
class Solution {
    public int countOdds(int low, int high) {
        if(high%2==0) high--;
        if(low%2 ==0) low++;
        return (high-low)/2+1;
    }
}