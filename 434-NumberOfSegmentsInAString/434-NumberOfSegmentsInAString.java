// Last updated: 7/9/2026, 5:21:40 PM
class Solution {
    public int countSegments(String s) {
                
        String[] str = s.split(" ");
        int count = 0;
        for (String i : str)
        {
            if (!Objects.equals(i, ""))
            {
                count++;
            }
        }
        return count;
    }
}