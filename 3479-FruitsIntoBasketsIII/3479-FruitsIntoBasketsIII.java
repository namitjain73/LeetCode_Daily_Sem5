// Last updated: 8/7/2025, 12:36:04 AM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int[] segmenttree = new int[4*n];
        Arrays.fill(segmenttree,-1);

        build(0,0,n-1,segmenttree,baskets);

        int unplaced = 0;
        for(int i : fruits){
            if( placed(0,0,n-1,segmenttree,i)== false){
                unplaced++;
            }
        }
        return unplaced;

        
    }

    public static boolean placed(int i , int l , int r , int[] segmenttree , int fruit){
        if(segmenttree[i] < fruit){
            return false;
        }

        if(l == r){
            segmenttree[i]= -1; // palced ho gya
            return true;

        }

        boolean place = false;
        int mid= l + (r-l) / 2;
        if(segmenttree[2*i+1] >= fruit){
            place = placed(2*i+1,l,mid,segmenttree,fruit);
        }else place = placed(2*i+2,mid+1,r,segmenttree,fruit);

        segmenttree[i] = Math.max(segmenttree[2*i+1],segmenttree[2*i+2]);
        return place;
    }

    public static void build(int i , int l , int r, int[] segmenttree , int[] baskets){
        if(l == r){
            segmenttree[i] = baskets[l];
            return;
        }

        int mid = l + (r-l) / 2;
        build(2*i+1 , l , mid , segmenttree , baskets);
        build(2*i+2 , mid + 1 , r , segmenttree , baskets);

        segmenttree[i] = Math.max(segmenttree[2*i+1] ,segmenttree[2*i+2]);
    }
}