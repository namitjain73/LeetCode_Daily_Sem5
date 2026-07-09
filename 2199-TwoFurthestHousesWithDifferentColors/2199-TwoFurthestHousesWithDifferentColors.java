// Last updated: 7/9/2026, 5:12:26 PM
class Solution {
    public int maxDistance(int[] colors) {
       int dist=0;
       int left=colors[0];
       int n=colors.length;
       int right=colors[n-1];
       //fixing the first element as left keeping it fixed and checking from other end
       for(int i=n-1;i>0;i--)
       {
        if(left != colors[i]){
         dist= Math.max(dist,i-0);
        }
       }
         //fixing the last element as right element keepingit as  fixed and checking from another end
       for(int j=0;j<n-2;j++){
        if(right != colors[j]){
          dist= Math.max(dist,n-1-j);
        }
       }
       

    return dist;


    }

}