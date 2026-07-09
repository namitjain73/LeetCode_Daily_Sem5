// Last updated: 7/9/2026, 5:13:05 PM
class Solution {
    public int[] findOriginalArray(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if(n % 2 == 1 || n == 0) return new int[0];
        int[] num= new int[n/2];
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0 ; i< n ; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        //System.out.println(map);
        int j = 0;

        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.getOrDefault(arr[i],0)-1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                if(!map.containsKey(arr[i]*2)) return new int[0];
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            }
            if(map.containsKey(arr[i]*2) && map.containsKey(arr[i])){
                map.put(arr[i], map.getOrDefault(arr[i],0)-1);
                if(map.get(arr[i]) == 0) map.remove(arr[i]);
                num[j++]= arr[i];
                map.put(arr[i]*2, map.getOrDefault(arr[i]*2,0)-1);
                if(map.get(arr[i]*2) <= 0) map.remove(arr[i]*2);
            }
            if(num.length == j) break;

            //System.out.println(arr[i] + " " + map);
        }
        return num;
    }
}