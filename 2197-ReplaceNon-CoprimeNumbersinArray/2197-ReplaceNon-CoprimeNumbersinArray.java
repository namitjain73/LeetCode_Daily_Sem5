// Last updated: 9/16/2025, 11:34:05 PM
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        // Stack<Integer>  st = new Stack<>();
        // for(int i = 0 ; i < nums.length ; i++){
        //     int curr = nums[i];
        //     while(!st.isEmpty() && gcd(curr,st.peek()) > 1){
        //         curr = (int)lcm(curr,st.pop());
        //     }
        //     st.push(curr);
        // }
        // List<Integer> ll = new ArrayList<>();
        // for(int i : st){
        //     ll.add(i);
        // }
        // return ll;
        List<Integer> ll = new ArrayList<>();
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i];
            while(j > 0 && gcd(curr,ll.get(j-1)) > 1){
                curr = (int)lcm(curr,ll.get(j-1));
                ll.remove(j-1);
                j--;
            }
            ll.add(curr);
            j++;
        }
        return ll;
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }
}