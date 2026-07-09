// Last updated: 7/9/2026, 5:21:26 PM
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String,Integer> map = new HashMap<>();
        return solver(strs, 0 , n , m, map);
    }
    public int solver(String[] str , int i , int m , int n , Map<String,Integer> map){
        if(i >= str.length) return 0;

        String key = i + "," + m + "," + n;
        if(map.containsKey(key)) return map.get(key);

        int ones = countOnes(str[i]);
        int zeros = countZeros(str[i]);

        int take = 0;
        if(ones <= m && zeros <= n){
            take = 1 + solver(str,i+1,m-ones,n-zeros,map);
        }
        int skip = solver(str,i+1,m,n,map);
        int max = Math.max(take,skip);
        map.put(key,max);
        return max;
    }

    public int countOnes(String s){
        int c = 0;
        // System.out.print(s+" ");
        for(char ch : s.toCharArray()){
            if(ch == '1') c++;
        }
        // System.out.print(c+" ");

        return c;
    }

    public int countZeros(String s){
        int c = 0;
        for(char ch : s.toCharArray()){
            if(ch == '0') c++;
        }
        // System.out.print(c+" ");

        return c;
    }
}