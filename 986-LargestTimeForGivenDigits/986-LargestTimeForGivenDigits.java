// Last updated: 7/9/2026, 5:18:42 PM
class Solution {
    public String largestTimeFromDigits(int[] arr) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0)+1);
        }

        String ans = "";
        
        // solve last most digit -- only valid are 2, 1, 0
        for(int i=2; i>=0 ;i--) {
            if(hmap.containsKey(i)) {
                ans = ans + Integer.toString(i);
                hmap.put(i, hmap.get(i)-1);
                break;
            }
        }
        if(ans.length() == 0) {
            return "";
        }

        // solve second last most digit -- if 1st digit is 2, then 3,2,1,0 are valid
        //                              -- if 1st digit is 1/0, then all 9 to 0 are valid
        for(int i=9; i>=0 ;i--) {
            if(Integer.parseInt(ans) == 2 && i>3) {
                continue;
            }
            if(hmap.containsKey(i) && hmap.get(i) > 0) {
                ans = ans + Integer.toString(i);
                hmap.put(i, hmap.get(i)-1);
                break;
            }
        }
        if(ans.length() < 2) {
            return "";
        }
        ans = ans + ":";

        // solve third last most digit -- only valid are 5,4,3,2,1,0
        for(int i=5; i>=0 ;i-- ) {
            if(hmap.containsKey(i) && hmap.get(i) > 0) {
                ans = ans + Integer.toString(i);
                hmap.put(i, hmap.get(i)-1);
                break;
            }
        }
        
        if(ans.length() < 4) {
            // both remaining numbers are > 5, so we can see if we can move this number to hours 2nd digit as this have larger range (only if the first digit is 2)
            // we should also check the 2nd digit of hours is not 2 or 3, because (26-29) and (36-39) are invalid
            if(ans.charAt(0) == '2' && (ans.charAt(1) == '1' || ans.charAt(1) == '0')) {
                for(int i=9; i>=6; i--) {
                    if(hmap.containsKey(i) && hmap.get(i) > 0) {
                        ans = ans.charAt(1) + Integer.toString(i) + ":" + ans.charAt(0);
                        hmap.put(i, hmap.get(i)-1);
                        break;
                    }
                }
            } else
                return "";
        }

        // solve fourth last most digit -- all digits are valid
        for(int i=9; i>=0 ;i-- ) {
           
            if(hmap.containsKey(i) && hmap.get(i) > 0) {
                ans = ans + Integer.toString(i);
                hmap.put(i, hmap.get(i)-1);
                break;
            }
        }
        
        if(ans.length() < 5) {
            return "";
        }

        return ans;


        
    }
}