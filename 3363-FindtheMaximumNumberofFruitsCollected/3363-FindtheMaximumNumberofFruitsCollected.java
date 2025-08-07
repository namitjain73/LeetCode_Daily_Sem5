// Last updated: 8/7/2025, 11:23:35 PM
class Solution {
    int n;
    int[][] memo;
    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        memo = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(memo[i],-1);
        }
        int c1 = countC1(fruits);
        int c2 = countC2(0 , n-1 , fruits);
        int c3 = countC3(n-1 , 0 , fruits);

        return c1 + c2 + c3;
    }

    public int countC3(int i , int j , int[][] fruits){
        
        if(i >= n || i < 0 || j >= n) return 0;
        if(i== n-1 && j == n-1) return 0;
        if(i == j || i < j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        
        

        int bottomleft = fruits[i][j] + countC3(i - 1 , j + 1 , fruits);
        int down = fruits[i][j] + countC3(i , j + 1, fruits);
        int right = fruits[i][j] + countC3(i + 1, j + 1 , fruits);
        memo[i][j] = Math.max(bottomleft , Math.max(down , right));;

        return memo[i][j];
    }

    public int countC2(int i , int j , int[][] fruits){
        
        if(i >= n || j < 0 || j >= n) return 0;
        if(i== n-1 && j == n-1) return 0;
        if(i == j || i > j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        


        int bottomleft = fruits[i][j] + countC2(i + 1 , j - 1 , fruits);
        int down = fruits[i][j] + countC2(i + 1 , j , fruits);
        int right = fruits[i][j] + countC2(i + 1, j + 1 , fruits);
        memo[i][j] =Math.max(bottomleft , Math.max(down , right));

        return memo[i][j];
    }

    public int countC1(int[][] fruits){
        int i = 0;
        int c = 0;
        while(i < n){
            c += fruits[i][i];
            i++;
        }
        return c;
    }
}