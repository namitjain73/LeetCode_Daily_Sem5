// Last updated: 7/9/2026, 5:10:25 PM
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int last = 0; 
        int j = 0; 
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < buses.length ; i++){
            int count = 0;
            while(j < passengers.length && count < capacity && passengers[j] <= buses[i]){
                last = passengers[j];
                set.add(passengers[j++]);
                    count++;
            }
            if(i == buses.length - 1 && count < capacity && last < buses[i]){
                return buses[buses.length - 1];
            }
        }
        if(set.size() == 0) return buses[buses.length - 1];
        while(set.contains(last)) last--;
        
        return last;
    }
}