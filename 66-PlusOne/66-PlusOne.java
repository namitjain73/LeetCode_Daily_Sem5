// Last updated: 7/9/2026, 5:25:06 PM
class Solution {
    public int[] plusOne(int[] arr) {
        int n = arr.length;
        List<Integer> ll = new ArrayList<>();
        int c = 0;
        int sum = 0;
        for(int i = n-1 ; i >=0 ; i--){
            sum += arr[i];
            if(i  == n-1) sum++;
            ll.add(0 , sum % 10);
            sum = sum / 10;
        }
        if(sum != 0){
            ll.add(0,sum);
        }
        int[] a = new int[ll.size()];
        int j = 0;
        for(int i : ll) a[j++] = i;
        return a;
    }
}