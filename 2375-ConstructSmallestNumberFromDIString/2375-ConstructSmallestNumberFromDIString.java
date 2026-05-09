// Last updated: 5/9/2026, 8:24:17 PM
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int ans = 0;
4        int n = matrix.length;
5        int[] arr = new int[matrix[0].length];
6        for(int i = n-1 ; i >= 0 ; i--){
7            for(int j = 0 ; j < matrix[0].length ; j++){
8                if(matrix[i][j] == '0') arr[j]= 0;
9                else arr[j]++;
10            }
11            ans = Math.max(ans , rectangle(arr));
12        }
13        return ans;
14    }
15    public int rectangle(int[] arr){
16        Stack<Integer> st = new Stack<>();
17        int ans= 0;
18
19
20        for(int i = 0 ; i < arr.length ; i++){
21            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
22                int h = arr[st.pop()];
23                int r = i;
24                if(st.isEmpty()){
25                    ans = Math.max(ans , r*h);
26                }else{
27                    int l = st.peek();
28                    ans = Math.max(ans , h * (r - l - 1));
29                }
30            }
31            st.push(i);
32        }
33
34        int r = arr.length;
35        while(!st.isEmpty()){
36            int h = arr[st.pop()];
37            if(st.isEmpty()){
38                ans = Math.max(ans , r*h);
39            }else{
40                int l= st.peek();
41                ans = Math.max(ans , h * (r - l - 1));
42            }
43        }
44        return ans;
45    }
46}