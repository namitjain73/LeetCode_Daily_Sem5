// Last updated: 7/9/2026, 4:58:45 PM
class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ll = new ArrayList<>();
        int num = 1;
        while(n > 0){
            int rem = n % 10;
            if(rem != 0){
            ll.add(rem*num);
            }
            n = n / 10;
            num = num*10;
        }

        Collections.sort(ll, Collections.reverseOrder());
        int[] arr = new int[ll.size()];
        int j = 0;
        for(int i : ll) arr[j++] = i;
        return arr;
    }
}