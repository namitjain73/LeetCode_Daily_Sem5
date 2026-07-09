// Last updated: 7/9/2026, 5:19:57 PM
class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] arr = new boolean[33];
        arr[0] = true;
        arr[1]= true;
        for(int i = 2; i * i < arr.length; i++){    
            if(arr[i]) continue;
    
            for(int j = i * i; j < arr.length; j += i){
                arr[j] = true;
            }
        }
        int ans = 0;
        for(int i = left ; i<= right ; i++){
            int setBit = Integer.bitCount(i);
            System.out.println(setBit + " " + i + " " + arr[setBit]);
            if(!arr[setBit]) ans++;
        }
        return ans;
    }
}