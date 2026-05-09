// Last updated: 5/9/2026, 7:01:08 PM
1class Solution {
2    public int largestRectangleArea(int[] arr) {
3        Stack<Integer> st = new Stack<>();
4        int ans = 0;
5
6        for(int i = 0 ; i < arr.length ; i++){
7            while(!st.empty() && arr[i] < arr[st.peek()]){
8                int h = arr[st.pop()];
9                int r = i;
10                if(st.empty()){
11                    ans = Math.max(ans,h*r);
12                }else{
13                    int l = st.peek();
14                    ans = Math.max(ans , h * (r - l - 1));
15                }
16            }
17            st.push(i);
18        }
19
20        int r = arr.length;
21        while(!st.empty()){
22            int h = arr[st.pop()];
23            if(st.empty()){
24                ans = Math.max(ans,h*r);
25            }else{
26                int l = st.peek();
27                ans = Math.max(ans , h * (r - l - 1));
28            }
29        }
30        return ans;
31    }
32}