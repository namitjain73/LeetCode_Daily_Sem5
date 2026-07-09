// Last updated: 7/9/2026, 5:15:00 PM
class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n=boxes.length, presum[]=new int[n+1], preWeight[]=new int[n+1], mb=maxBoxes, mw=maxWeight;
        
        for(int i=0; i<n; i++){
            if(i>0) presum[i+1]=presum[i]+(boxes[i][0]==boxes[i-1][0]?0:1);
            preWeight[i+1]=boxes[i][1]+preWeight[i];
        }
        int[] dp=new int[n+1];
        Arrays.fill(dp,200000);
        dp[0]=0;
        LinkedList<Integer> q=new LinkedList<>();
        
        for(int i=1; i<=n; i++){
            dp[i]=dp[i-1]+2;
            while(q.size()>0 &&(i-q.peek()+1>mb || preWeight[i]-preWeight[q.peek()-1]>mw)) q.poll();
            if(q.size()>0) dp[i]=Math.min(dp[i],dp[q.peek()-1]+presum[i]-presum[q.peek()]+2);
            while(q.size()>0 && dp[q.peekLast()-1]-presum[q.getLast()]>dp[i-1]-presum[i]) q.pollLast();
            q.offer(i);
        }
        return dp[n];
    }
}