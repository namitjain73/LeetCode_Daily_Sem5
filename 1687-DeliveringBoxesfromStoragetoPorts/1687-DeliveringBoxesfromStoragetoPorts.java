// Last updated: 1/28/2026, 11:32:12 PM
1class Solution {
2    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
3        int n=boxes.length, presum[]=new int[n+1], preWeight[]=new int[n+1], mb=maxBoxes, mw=maxWeight;
4        
5        for(int i=0; i<n; i++){
6            if(i>0) presum[i+1]=presum[i]+(boxes[i][0]==boxes[i-1][0]?0:1);
7            preWeight[i+1]=boxes[i][1]+preWeight[i];
8        }
9        int[] dp=new int[n+1];
10        Arrays.fill(dp,200000);
11        dp[0]=0;
12        LinkedList<Integer> q=new LinkedList<>();
13        
14        for(int i=1; i<=n; i++){
15            dp[i]=dp[i-1]+2;
16            while(q.size()>0 &&(i-q.peek()+1>mb || preWeight[i]-preWeight[q.peek()-1]>mw)) q.poll();
17            if(q.size()>0) dp[i]=Math.min(dp[i],dp[q.peek()-1]+presum[i]-presum[q.peek()]+2);
18            while(q.size()>0 && dp[q.peekLast()-1]-presum[q.getLast()]>dp[i-1]-presum[i]) q.pollLast();
19            q.offer(i);
20        }
21        return dp[n];
22    }
23}