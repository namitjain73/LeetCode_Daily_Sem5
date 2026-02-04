// Last updated: 2/4/2026, 11:55:42 PM
1class Solution {
2    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
3        Arrays.sort(buses);
4        Arrays.sort(passengers);
5        
6        int last = 0; 
7        int j = 0; 
8        HashSet<Integer> set = new HashSet<>();
9        
10        for(int i = 0 ; i < buses.length ; i++){
11            int count = 0;
12            while(j < passengers.length && count < capacity && passengers[j] <= buses[i]){
13                last = passengers[j];
14                set.add(passengers[j++]);
15                    count++;
16            }
17            if(i == buses.length - 1 && count < capacity && last < buses[i]){
18                return buses[buses.length - 1];
19            }
20        }
21        if(set.size() == 0) return buses[buses.length - 1];
22        while(set.contains(last)) last--;
23        
24        return last;
25    }
26}