// Last updated: 7/9/2026, 5:19:13 PM
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int ele : bills){
            if(ele == 5){
                five++;
            }
            else if(ele == 10){
                if(five > 0){
                    five--;
                    ten++;
                }else return false;
            }else{
                if((ten > 0 && five > 0)){
                    ten--;
                    five--;
                }else if((five > 2)){
                    five -= 3;
                }else return false;
            }
        }
        return true;
        
    }
}