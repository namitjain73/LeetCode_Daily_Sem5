// Last updated: 10/2/2025, 12:04:52 AM
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });

        List<int[]> ll = new ArrayList<>();
        for(int[] p : people){
            ll.add(p[1], p);
        }
        return ll.toArray(new int[people.length][2]);
    }
}