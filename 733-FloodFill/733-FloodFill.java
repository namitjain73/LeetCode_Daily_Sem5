// Last updated: 12/30/2025, 2:53:32 PM
1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        helper(image , sr , sc , color , image[sr][sc]);
4        return image;
5    }
6    public void helper(int[][] image, int sr, int sc, int color , int str){
7        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
8            return;
9        }
10        if(image[sr][sc] != str || image[sr][sc] == color) return;
11
12        image[sr][sc] = color;
13        // up
14        helper(image,sr-1,sc,color,str);
15        // down
16        helper(image,sr+1,sc,color,str);
17        // left
18        helper(image,sr,sc+1,color,str); 
19        // right
20        helper(image,sr,sc-1,color,str);
21
22    }
23}