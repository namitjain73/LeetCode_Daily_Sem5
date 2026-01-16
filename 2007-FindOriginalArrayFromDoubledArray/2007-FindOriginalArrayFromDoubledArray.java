// Last updated: 1/16/2026, 11:20:44 PM
1class Solution {
2    public int[] findOriginalArray(int[] arr) {
3        Arrays.sort(arr);
4        int n = arr.length;
5        if(n % 2 == 1 || n == 0) return new int[0];
6        int[] num= new int[n/2];
7        HashMap<Integer,Integer> map= new HashMap<>();
8        for(int i = 0 ; i< n ; i++){
9            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
10        }
11        //System.out.println(map);
12        int j = 0;
13
14        for(int i = 0 ; i < n ; i++){
15            if(map.containsKey(arr[i])){
16                map.put(arr[i], map.getOrDefault(arr[i],0)-1);
17                if(map.get(arr[i]) == 0) map.remove(arr[i]);
18                if(!map.containsKey(arr[i]*2)) return new int[0];
19                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
20            }
21            if(map.containsKey(arr[i]*2) && map.containsKey(arr[i])){
22                map.put(arr[i], map.getOrDefault(arr[i],0)-1);
23                if(map.get(arr[i]) == 0) map.remove(arr[i]);
24                num[j++]= arr[i];
25                map.put(arr[i]*2, map.getOrDefault(arr[i]*2,0)-1);
26                if(map.get(arr[i]*2) <= 0) map.remove(arr[i]*2);
27            }
28            if(num.length == j) break;
29
30            //System.out.println(arr[i] + " " + map);
31        }
32        return num;
33    }
34}