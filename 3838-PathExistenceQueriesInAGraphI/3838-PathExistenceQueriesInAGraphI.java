// Last updated: 7/9/2026, 5:01:09 PM
class Solution {
    public class Node{
        int val;
        int rank;
        Node parent;
    }
    HashMap<Integer,Node> mp = new HashMap<>();
    public void createSet(int val){
        Node nn = new Node();
        nn.val = val;
        nn.rank = 0;
        nn.parent = nn;
        mp.put(val,nn);
    }

    public int find(int v){
        Node nn = mp.get(v);
        return find(nn).val;
    }

    public Node find(Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node rn = find(nn.parent);
        nn.parent = rn;
        return rn;
    }

    public void union(int v1, int v2){
        Node nn1 = mp.get(v1);
        Node nn2 = mp.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);
        if(rn1.rank == rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        }
        else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        }
        else{
            rn1.parent = rn2;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        for(int i = 0; i<n; i++){
            createSet(i);
        }

        for(int i = 1; i<nums.length; i++){
            if(nums[i]-nums[i-1] <= maxDiff){
                union(i,i-1);
            }
        }

        int i = 0;
        boolean[] ans = new boolean[queries.length];
        for(int[] arr : queries){
            int a = arr[0];
            int b = arr[1];
            ans[i++] = find(a) == find(b);
        }
        return ans;
    }
}