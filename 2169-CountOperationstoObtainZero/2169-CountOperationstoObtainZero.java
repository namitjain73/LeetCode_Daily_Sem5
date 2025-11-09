// Last updated: 11/9/2025, 8:36:38 PM
class Solution {
    public int countOperations(int num1, int num2) {
        int op= 0;
        while(num1 != 0 && num2 != 0){
            if(num1 < num2) num2 =  num2 - num1;
            else num1 = num1 - num2;
            op++;
        }
        return op;
    }
}