// Last updated: 1/28/2026, 10:53:16 PM
1class Solution {
2    public int[] countRectangles(int[][] rectangles, int[][] points) {
3        int[] res = new int[points.length];
4        List<List<Integer>> group = new ArrayList<>(101);
5        for(int i = 0; i < 101; i++){
6            group.add(new ArrayList<>());
7        }
8        
9        for(int[] rec : rectangles){
10            int l = rec[0];
11            int h = rec[1];
12            group.get(h).add(l);
13        }
14        
15        for(int i = 0; i < 101; i++){
16            Collections.sort(group.get(i));   
17        }
18        
19        for(int i = 0; i < points.length; i++){
20            int count = 0;
21            int x = points[i][0];
22            int y = points[i][1];
23            for(int j = y; j < 101; j++){
24                List<Integer> cur = group.get(j);
25                int index = binarySearch(cur, x);
26                count += cur.size() - index;
27            }
28            res[i] = count;
29        }
30
31        return res;
32    }
33    
34    private int binarySearch(List<Integer> list, int x){
35        int left = 0;
36        int right = list.size();
37        while(left < right){
38            int mid = left + (right - left) / 2;
39            if(list.get(mid) >= x){
40                right = mid;
41            } else{
42                left = mid + 1;
43            }
44        }
45        return left;
46    }
47}