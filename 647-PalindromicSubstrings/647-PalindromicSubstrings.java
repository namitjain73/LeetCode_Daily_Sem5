// Last updated: 9/13/2025, 12:30:02 PM
class Solution {
    public int countSubstrings(String s) {
        int odd = 0;
        int even = 0 ;
        for(int axis = 0; axis < s.length() ; axis++){
            for(int orbit = 0 ; (axis - orbit) >= 0 && (axis + orbit) < s.length()  ; orbit++){
                if(s.charAt(axis-orbit) != s.charAt(axis+orbit)) break;
                odd++;
            }
        }

        for(double axis = 0.5; axis < s.length() ; axis++){
            for(double orbit = 0.5 ; (int)(axis - orbit) >= 0 && (int)(axis + orbit) < s.length()  ; orbit++){
                if(s.charAt((int)(axis-orbit)) != s.charAt((int)(axis+orbit))) break;
                even++;
            }
        }
        return odd+even;
    }
}