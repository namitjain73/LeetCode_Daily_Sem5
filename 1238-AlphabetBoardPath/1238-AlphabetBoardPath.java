// Last updated: 7/9/2026, 5:17:42 PM
class Solution {
    public String alphabetBoardPath(String target) {
        int x = 0;
        int y = 0;
        StringBuilder path = new StringBuilder();
        for(char ch : target.toCharArray()){
            int x1 = (ch - 'a')/5;
            int y1 = (ch - 'a')%5;
            while(x > x1){
                path.append('U');
                x--;
            }
            while(y < y1){
                path.append('R');
                y++;
            }
            while(y > y1){
                path.append('L');
                y--;
            }
            while(x < x1){
                path.append('D');
                x++;
            }
            path.append('!');
        }
        return path.toString();
    }
}